package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.customerInfoBO;
import com.nt.dao.CustomerInfoDAO;
import com.nt.dto.customerInfoDTO;

public class CustomerInfoServiceImpl implements CustomerInfoService {

	private CustomerInfoDAO dao;
	public CustomerInfoServiceImpl(CustomerInfoDAO dao) {
		this.dao = dao;
	}
	
	/*
	 * This Method is used display the all customer records
	 */
	@Override
	public List<customerInfoDTO> findAllCustomers() {
		List<customerInfoDTO> listDTO = new ArrayList();
		List<customerInfoBO> listBO = null;
		// use DAO
		listBO = dao.getAllCustomers();
		// convert ListBO to listDTO
		listBO.stream().forEach(bo -> {
			customerInfoDTO dto = new customerInfoDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});

		return listDTO;
		}
	
	/*
	 * This method is used to display the edit form page based on cno
	 */
	
	@Override
	public customerInfoDTO findCustomerByCno(int cno) {
		customerInfoBO bo = null;
		customerInfoDTO dto = null;
		// use DAO
		bo = dao.getCustomerByCno(cno);
		// convert BO to DTO
		dto = new customerInfoDTO();
		BeanUtils.copyProperties(bo, dto);
		
		return dto;
 

	}
	
	/*
	 * This method is used to modify the records
	 */

	@Override
	public String modifyCustomerByCno(customerInfoDTO dto) {
		int count=0;
		customerInfoBO bo=null;
		// Convert DTO to BO
		bo=new customerInfoBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.updateCustomerByCno(bo);
		if(count==0)
			return dto.getCno()+" updatation failed";
		else
			return dto.getCno()+" updatation succeded";

	}

	
	/*
	 * This method is used delete the particular record
	 */
	@Override
	public String removeCustomerByCno(int cno) {
		int count=0;
		//use DAO	
		count=dao.deleteCustomerByCno(cno);
		if(count==0)
			return "Record not found for Deletion";
		else
			return "Record  found and Deleted";

	}

	@Override
	public String register(customerInfoDTO dto) {
		int count = 0;
		customerInfoBO bo = null;
		// convert DTO to BO
		bo = new customerInfoBO();
		BeanUtils.copyProperties(dto, bo);
		// use DAO
		count = dao.insert(bo);
		if (count == 0)
			return "Customer registration failed";
		else
			return "Customer  registration succeded";

	}

}
