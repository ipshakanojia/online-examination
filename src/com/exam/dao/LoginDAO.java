package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	public void getDetail()
	{}

	public void authenticate(String username, String password) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "");

			PreparedStatement ps = con.prepareStatement("select password from registration where name=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			String passwordFromDB="";
			if(rs.next())
			{
			passwordFromDB=rs.getString(1);
			System.out.println("Password from DB : "+passwordFromDB);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
