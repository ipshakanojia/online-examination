package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.exam.dto.AddQuestionDTO;

public class AddQuestionDAO {

	public int addQuestionDetails(AddQuestionDTO addQuestionDTO) {
		// TODO Auto-generated method stub
		int status=0;
		 try{  
			 Class.forName("com.mysql.jdbc.Driver");  
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","");  
			 PreparedStatement ps=con.prepareStatement("insert into questiondetails values(?,?,?,?,?,?)");  
			 ps.setString(1,addQuestionDTO.getQuestion());  
			 ps.setString(2,addQuestionDTO.getAnswer1());  
			 ps.setString(3,addQuestionDTO.getAnswer2());  
			 ps.setString(4,addQuestionDTO.getAnswer3());  
			 ps.setString(5,addQuestionDTO.getAnswer4()); 
			 ps.setString(6,addQuestionDTO.getCanswer());   
			 status=ps.executeUpdate();  
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }

		return status;
	}

}
