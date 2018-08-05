package com.exam.action;

import com.exam.dao.RegistrationDAO;
import com.exam.dto.RegistrationDTO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegistrationAction extends ActionSupport implements ModelDriven<RegistrationDTO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RegistrationDTO registrationDTO = new RegistrationDTO();
	RegistrationDAO registrationDAO = new RegistrationDAO();
	

	public String execute()
	{	
		int val = registrationDAO.save(registrationDTO);
		if(val>0)
		{
			return "success";			
		}
		else
		{
			return "error";
		}
		
	}
	@Override
	public RegistrationDTO getModel() {
		// TODO Auto-generated method stub
		return registrationDTO;
	}
}
