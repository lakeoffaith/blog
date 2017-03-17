package excelDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import com.ijoy.excel.ExportExcel;
import com.ijoy.model.Student;

public class Start {
	public static void main(String[] args) throws IOException{
		ExportExcel ee=new ExportExcel<Student>();
		String title="excel poi 百万数据测试";
		String[] headers=new String[]{"姓名","号码"};
		int total=ee.getTotalFromDB();
		System.out.println(total);
		ExportExcel<Student> excel=new ExportExcel<>();
		long oldTime=new Date().getTime();
		OutputStream out=new FileOutputStream(new File("F://eclipseworkspace//excelDemo//excelDemo2.xlsx"));
		excel.sxssfexportExcel(title, headers, ee.getDataSetFromDB(1, total), out);
		System.out.println("花费时间："+(new Date().getTime()-oldTime));
		
	}
}
