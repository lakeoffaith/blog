##redux_componentWillReceive_ListView

####explain
	
    当redux和listView结合的时候，如何根据state的变化去设置dataSource,采用的是componentWillReceiveProps,不像componentDidUpdate() ,a setState 在componentWillReceiveProps中被调用，不会重新触发render,这样会更快。
    

####code

```
	componentWillReceiveProps(nextProps){
    	if(nextProps.todos!==this.props.elements){
        	this.setState({
            	todos:nextProps.todos,
                dataSource:this.state.dataSource.cloneWithRows(nextProps.todos)
            })
        }
    }
```

####dug

	采用redux,我们就要让redux管理我们的state,
    

####code

```
  class TodoList extends Component{
  	render(){
    	return(
        	<ListView
            	dataSource={this.props.dataSource}
                renderRow={(rowData)=><View><Text>{rowData.name}</Text></View>}
            />
        );
    }
  }
  
  TodoList.propTypes={
  	dataSource:PropTypes.object
  };
  const DS=new ListView.DataSource({
    rowHasChanged:(r1,r2)=>r1!==r2
  });
  function mapStateToProps(state){
    return{
    	dataSource:DS.cloneWithRows(state.todos),
    };
  }
  export default connect(mapStateToProps)(TodoList);
```


* * *
last update 2016-09-05