package com.exam.action;

import com.exam.dao.AddQuestionDAO;
import com.exam.dto.AddQuestionDTO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddQuestionAction implements ModelDriven<AddQuestionDTO> {
	
	
	
	AddQuestionDAO addQuestionDAO = new AddQuestionDAO();
	AddQuestionDTO addQuestionDTO = new AddQuestionDTO();

	public String execute() {
		int val = addQuestionDAO.addQuestionDetails(addQuestionDTO);
		if (val > 0) {
			return "success";
		} else {
			return "error";
		}
	}

	
	@Override
	public AddQuestionDTO getModel() {
		// TODO Auto-generated method stub
		return addQuestionDTO;
	}
}
