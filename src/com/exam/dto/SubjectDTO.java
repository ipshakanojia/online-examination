package com.exam.dto;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectDTO {

	public class RadioButtonAction extends ActionSupport {

		private List<String> subject;
		private String yourSubject;

		public RadioButtonAction() {
			subject.add("JAVA");
			subject.add("C++");
		}

		public String execute() {
			return SUCCESS;
		}
	}
}
