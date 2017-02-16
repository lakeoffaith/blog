package com.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import com.dao.CommentMapper;
import com.modal.Comment;
import com.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService{
	@Autowired(required=true)
	protected RedisTemplate<Serializable,Serializable> redisTemplate;
	@Autowired
	protected CommentMapper commentMapper;
	@Override
	public List<Comment> findAll() {
		List<Comment> result=redisTemplate.execute(new RedisCallback<List<Comment>>() {

			@Override
			public List<Comment> doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<Serializable> serializer = (RedisSerializer<Serializable>) redisTemplate.getDefaultSerializer();
				byte[] key=serializer.serialize("Comment_findAll");
				byte[] value=connection.get(key);
				if(value==null){
					System.out.println("redis不存在数据,mybatis中取");
					List<Comment> myBatisComments=commentMapper.findAll();
					byte[] myBatisCommentsValue=serializer.serialize((Serializable) myBatisComments);
					connection.set(key, myBatisCommentsValue);
					return myBatisComments;
				}
				System.out.println("redis存在数据,redis中取");
				List<Comment> comments=(List<Comment>) serializer.deserialize(value);
				return comments;
			}
		});
		System.out.println("结果条数 = "+result.size());
		return result;
	}
	@Override
	public void add(Comment comment) {
		commentMapper.insert(comment);
	}
	@Override
	public void delete(int index) {
		commentMapper.delete(index);
		//redis中删除key
		redisTemplate.execute(new RedisCallback<Serializable>() {

			@Override
			public Serializable doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<Serializable> serializer = (RedisSerializer<Serializable>) redisTemplate.getDefaultSerializer();
				byte[] key=serializer.serialize("Comment_findAll");
				if(connection.get(key)!=null){
					connection.del(key);
				}
				return null;
			}
		});
	}

}
