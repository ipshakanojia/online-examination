package com.exam.action;

import com.exam.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<LoginDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoginDTO loginDTO = new LoginDTO();

	public String execute() {

		if (loginDTO.getUsername().equals("alok") && loginDTO.getPassword().equals("alok")) {
			return "success";
		} else
			return "input";
	}

	public void validate() {
		if (loginDTO.getUsername().length() == 0) {
			addFieldError("username", getText("username.required"));
		}
		if (loginDTO.getPassword().length() == 0) {
			addFieldError("password", "Password is Empty");
		}
	}

	@Override
	public LoginDTO getModel() {
		// TODO Auto-generated method stub
		return loginDTO;
	}
}
