package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.exam.dto.QuizDTO;

public class QuizDAO {

	QuizDTO quizDTO = null;

	public ArrayList retrieveQuestions() {

		ArrayList<QuizDTO> list = new ArrayList<QuizDTO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "");

			PreparedStatement ps = con.prepareStatement("select * from questiondetails");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				quizDTO = new QuizDTO();
				quizDTO.setQuestion(rs.getString(1));
				quizDTO.setAnswer1(rs.getString(2));
				quizDTO.setAnswer2(rs.getString(3));
				quizDTO.setAnswer3(rs.getString(4));
				quizDTO.setAnswer4(rs.getString(5));
				list.add(quizDTO);
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static ArrayList examQuestionDetails1() {
		QuizDTO quizDTO = null;

		ArrayList<QuizDTO> list = new ArrayList<QuizDTO>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "");

			PreparedStatement ps = con.prepareStatement("select * from questiondetails limit");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				quizDTO = new QuizDTO();
				quizDTO.setQuestion(rs.getString(1));
				quizDTO.setAnswer1(rs.getString(2));
				quizDTO.setAnswer2(rs.getString(3));
				quizDTO.setAnswer3(rs.getString(4));
				quizDTO.setAnswer4(rs.getString(5));
				list.add(quizDTO);
				/*
				 * for (int i = 0; i < list.size(); i++) {
				 * System.out.println(list.get(i)); }
				 */
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public boolean checkAnswers(String question, String option) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "");
			PreparedStatement ps = con.prepareStatement("select canswer from questiondetails where question = ? ");
			ps.setString(1, question);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String correctAnswer = rs.getString(1);
				System.out.println(correctAnswer);
				if (correctAnswer.equals(option))
					return true;
				else
					return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// checkAnswers("what is your name?","alok");
	}

}
