package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.customerInfoBO;

public class CustomerInfoDAOImpl implements CustomerInfoDAO {
	private static final String GET_ALL_CUSTOMERS="SELECT CNO,CNAME,CADDR,CMBLNO,BillAMT FROM CUSTOMERINFO";
	private static final String GET_CUSTOMER_BY_CNO="SELECT CNO,CNAME,CADDR,CMBLNO,BILLAMT FROM CUSTOMERINFO WHERE CNO=?";
	private static final String UPDATE_CUSTOMER="UPDATE CUSTOMERINFO SET CNAME=?,CADDR=?,CMBLNO=?,BILLAMT=? WHERE CNO=?";
	private static final String  DELETE_CUSTOMER="DELETE FROM CUSTOMERINFO WHERE CNO=?";
	private static final String CUSTOMER_INSERT_QUERY="INSERT INTO CUSTOMERINFO VALUES(?,?,?,?,?)";
	
	
	//inject the jdbcTemplate
	private JdbcTemplate jt;
	public CustomerInfoDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	/*
	 * This method is used to display the All Records
	 */
	@Override
	public List<customerInfoBO> getAllCustomers() {
		List<customerInfoBO> listBO=null;
		listBO=jt.query(GET_ALL_CUSTOMERS,rs->{
			List<customerInfoBO> listBO1=null;
			customerInfoBO bo=null;
			listBO1=new ArrayList();
			while(rs.next()) {
				bo=new customerInfoBO();
				bo.setCno(rs.getInt(1));
				bo.setCname(rs.getString(2));
				bo.setCaddr(rs.getString(3));
				bo.setCmblNo(rs.getLong(4));
				bo.setBillAmt(rs.getFloat(5));
				listBO1.add(bo);
			}//while
			return listBO1;
		});
		return listBO;

	}

/*
 * This Method is used display the Edit form page 
 */
	@Override
	public customerInfoBO getCustomerByCno(int cno) {
		customerInfoBO bo=null;
		//use DAO
		bo=jt.queryForObject(GET_CUSTOMER_BY_CNO, (rs,index)->{
			customerInfoBO bo1=null;
			bo1=new customerInfoBO();
			bo1.setCno(rs.getInt(1));
			bo1.setCname(rs.getString(2));
			bo1.setCaddr(rs.getString(3));
			bo1.setCmblNo(rs.getLong(4));
			bo1.setBillAmt(rs.getFloat(5));
			return bo1;
		}, cno);
		
		return bo;

	}

/*
 * This method is used to Update the record based on cno
 */
	@Override
	public int updateCustomerByCno(customerInfoBO bo) {
		int  count=0;
		count=jt.update(UPDATE_CUSTOMER,bo.getCname(),bo.getCaddr(),bo.getCmblNo(),bo.getBillAmt(),bo.getCno());
		return count;

	}
	
	/*
	 * This Method is used to delete the record based on cno
	 */

	@Override
	public int deleteCustomerByCno(int cno) {
		int count=0;
		count=jt.update(DELETE_CUSTOMER,cno);
		return count;

	}

	@Override
	public int insert(customerInfoBO bo) {
		int count=0;
		count=jt.update(CUSTOMER_INSERT_QUERY, bo.getCno(),bo.getCname(),bo.getCaddr(),bo.getCmblNo(),bo.getBillAmt());
		return count;

	
	}

}
