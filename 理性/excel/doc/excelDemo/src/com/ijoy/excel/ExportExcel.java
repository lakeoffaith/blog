package com.ijoy.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import com.ijoy.model.Student;

public class ExportExcel<T> {

	
	public  List<Student> getDataSetFromDB(int start,int end) {
		List<Student> lists=new ArrayList<>();
		
		//数据库连接
		String connetionUrl="jdbc:sqlserver://localhost:1433;" +
				"databaseName=excelDemo";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		con = DriverManager.getConnection(connetionUrl,"sa","black");
    		stmt=con.createStatement();
    		int endStartDiff=end-start+1;
    		int startDiff=start-1>=0?start-1:0;
    		String sql="select top "+endStartDiff+" id,name,cellPhone from employee " +
    				"where id not in (select top " + startDiff + " id from employee)";
    		rs = stmt.executeQuery(sql);
    		while(rs.next()){
    			Student s=new Student(rs.getString(2),rs.getString(3));
    			lists.add(s);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try{rs.close();}catch(Exception e){};
			if(stmt!=null) try{stmt.close();}catch(Exception e){};
			if(con!=null) try{con.close();}catch(Exception e){};
		}
		return lists;
		
	}

	public int getTotalFromDB() {
		int total=0;
		String connetionUrl="jdbc:sqlserver://localhost:1433;" +
				"databaseName=excelDemo";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		con = DriverManager.getConnection(connetionUrl,"sa","black");
    		stmt=con.createStatement();
    		rs = stmt.executeQuery("select count(*) from employee");
    		
    		if(rs.next()){
    			total=rs.getInt(1);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try{rs.close();}catch(Exception e){};
			if(stmt!=null) try{stmt.close();}catch(Exception e){};
			if(con!=null) try{con.close();}catch(Exception e){};
		}
		return total;
	}
    
	
	public void sxssfexportExcel(String title,String[] headers,Collection<T> dataset,OutputStream out){
		SXSSFWorkbook wb=new SXSSFWorkbook();
		
		SXSSFSheet  sheet=wb.createSheet(title);
		SXSSFRow  row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			SXSSFCell cell = row.createCell(i);
			cell.setCellValue(headers[i]);
		}
		
		Iterator<T> it = dataset.iterator();
		int index=0;
		while(it.hasNext()){
			index++;
			SXSSFRow r=sheet.createRow(index);
			T t=it.next();
			Field[] fields = t.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				SXSSFCell c = r.createCell(i);
				String fieldName = fields[i].getName();
				String getMethodName = "get"
		                   + fieldName.substring(0, 1).toUpperCase()
		                   + fieldName.substring(1);
				try {
	                Class tCls = t.getClass();
	                Method getMethod = tCls.getMethod(getMethodName,new Class[] {});
	                Object value = getMethod.invoke(t, new Object[] {});
	                //判断值的类型后进行强制类型转换
	                String textValue = value.toString();
	                if(textValue!=null){
	                    Pattern p = Pattern.compile("^//d+(//.//d+)?$");  
	                    Matcher matcher = p.matcher(textValue);
	                    if(matcher.matches()){
	                       //是数字当作double处理
	                       c.setCellValue(Double.parseDouble(textValue));
	                    }else{
	                       XSSFRichTextString richString = new XSSFRichTextString(textValue);
	                     
	                       c.setCellValue(richString);
	                    }
	                }
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
		try {
			wb.write(out);
			out.close();
			System.out.println("完成");
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
		
	}
}

