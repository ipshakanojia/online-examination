package com.exam.action;

import com.exam.dto.QuizResultDTO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class QuizResultAction extends ActionSupport implements ModelDriven<QuizResultDTO> {

	QuizResultDTO quizResultDTO = new QuizResultDTO();;

	public String execute() {

		System.out.println("In Execute Method");
		System.out.println(quizResultDTO.getHquestion() + quizResultDTO.getAnswer0() + quizResultDTO.getAnswer1()
				+ quizResultDTO.getAnswer2());
		return "success";
	}

	@Override
	public QuizResultDTO getModel() {
		return quizResultDTO;
	}
}
