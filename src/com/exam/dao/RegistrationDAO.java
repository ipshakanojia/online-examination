package com.exam.dao;

import java.sql.DriverManager;
import java.sql.*; 
import com.exam.dto.RegistrationDTO;

public class RegistrationDAO {
 public int save(RegistrationDTO registrationDTO)
 {
	 int status=0;  
	 try{  
		 Class.forName("com.mysql.jdbc.Driver");  
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","");  
		 PreparedStatement ps=con.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?)");  
		 ps.setString(1,registrationDTO.getName());  
		 ps.setString(2,registrationDTO.getSurname());  
		 ps.setString(3,registrationDTO.getPassword());  
		 ps.setString(4,registrationDTO.getDob());  
		 ps.setString(5,registrationDTO.getEmail()); 
		 ps.setString(6,registrationDTO.getAddress());  
		 ps.setString(7,registrationDTO.getZip());  
		 ps.setString(8,registrationDTO.getPhone());  
		 status=ps.executeUpdate();  
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 System.out.println(registrationDTO.getName());
	return status;
 }
}
