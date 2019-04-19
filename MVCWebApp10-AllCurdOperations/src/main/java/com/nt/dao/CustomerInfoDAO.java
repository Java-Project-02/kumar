package com.nt.dao;

import java.util.List;

import com.nt.bo.customerInfoBO;

public interface CustomerInfoDAO {
	public List<customerInfoBO> getAllCustomers();
	public customerInfoBO  getCustomerByCno(int cno);
	  public  int  updateCustomerByCno(customerInfoBO bo);
	  public  int deleteCustomerByCno(int cno);
	  public  int insert(customerInfoBO bo);



}
