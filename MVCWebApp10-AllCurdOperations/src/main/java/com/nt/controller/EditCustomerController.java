package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.CustomerCommand;
import com.nt.dto.customerInfoDTO;
import com.nt.service.CustomerInfoService;

public class EditCustomerController extends SimpleFormController {
	private CustomerInfoService service;

	public EditCustomerController(CustomerInfoService service) {

		this.service = service;
	}
	
	@Override
	public Object formBackingObject(HttpServletRequest req) throws Exception {
		int cno=0;
		customerInfoDTO dto=null;
		CustomerCommand cmd=null;
		//read addtional req param values
		cno=Integer.parseInt(req.getParameter("cno"));
		//use serivce
		dto=service.findCustomerByCno(cno);
		//Convert DTO to Command obj
		cmd=new CustomerCommand();
		BeanUtils.copyProperties(dto,cmd);
		return cmd;
	}
	

	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		customerInfoDTO dto=null;
		String result=null;
		List<customerInfoDTO> listDTO=null;
		ModelAndView mav=null;
		//Convert Command obj to DTO
		dto=new customerInfoDTO();
		BeanUtils.copyProperties(((CustomerCommand)command), dto);
		//use Service
		result=service.modifyCustomerByCno(dto);
		listDTO=service.findAllCustomers();
		//return MAV
		mav=new ModelAndView();
		mav.setViewName("report_cust");
		mav.addObject("reportData",listDTO);
		mav.addObject("msg",result);
		return mav;
	}
	
	/*
	 * This method is used to avoid the double posting problem
	 */
	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return  new ModelAndView("dbl_post");

	}



}
