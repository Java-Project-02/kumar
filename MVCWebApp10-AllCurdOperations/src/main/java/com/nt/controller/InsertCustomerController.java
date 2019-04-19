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

public class InsertCustomerController extends SimpleFormController {
	private CustomerInfoService service;
	
	public InsertCustomerController(CustomerInfoService service) {
		this.service = service;
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object command,
			BindException errors) throws Exception {
		String resultMsg=null;
		CustomerCommand cmd=null;
		customerInfoDTO dto=null;
		ModelAndView mav=null;
		List<customerInfoDTO> listDTO=null;
		//convert cmd to DTO
		cmd=(CustomerCommand)command;
		dto=new customerInfoDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use Service
		resultMsg=service.register(dto);
		listDTO=service.findAllCustomers();
		//return MAV
		mav=new ModelAndView();
		mav.addObject("msg",resultMsg);
		mav.addObject("reportData",listDTO);
		mav.setViewName("report_cust");
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
