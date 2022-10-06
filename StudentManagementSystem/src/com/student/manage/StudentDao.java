package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	
	
public static boolean insertDB(Student st){
	boolean f=false;
try {
	Connection con=CP.createC();
	String q="insert into students(sname,sphone,scity)values(?,?,?)";
	PreparedStatement pstm= con.prepareStatement(q);
	pstm.setString(1, st.getStudentName());
	pstm.setString(2, st.getStudentPhone());
	pstm.setString(3, st.getStudentCity());
	pstm.executeUpdate();
	f=true;
}catch(Exception e) {
	e.printStackTrace();
}
return f;
}

public static void showAllStudent() {
	// TODO Auto-generated method stub
	
	try {
		Connection con=CP.createC();
		String q="select *from students";
		Statement stmt=con.createStatement();
		
		ResultSet set=stmt.executeQuery(q);
		while(set.next()) {
			int sid=set.getInt(1);
			String name=set.getString(2);
			String phone=set.getString(3);
			String city=set.getString(4);
			System.out.println("Student id : "+ sid);
			System.out.println("Student Name: "+name);
			System.out.println("Student phone: "+phone);
			System.out.println("Stdent city: "+city);
			System.out.println("**************************");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}

public static boolean deleteStudent(int id) {
	// TODO Auto-generated method stub
	boolean f=false;
try {
	Connection con=CP.createC();
	String q="delete from students where sid=?";
	PreparedStatement pstm= con.prepareStatement(q);
	pstm.setInt(1, id);
	
	pstm.executeUpdate();
	f=true;
}catch(Exception e) {
	e.printStackTrace();
}
return f;
	
}
}
