package com.smp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smp.Dao.DataObj;
import com.smp.model.Customer;
import com.smp.model.CustomerAccount;
@Service
public class Main implements CustomService {
     @Autowired
	private DataObj dao;
	public void createCustomer(Customer cust) {
	dao.saveCustomer(cust);
		
	}
	public	List<Customer> getCustomer()
	{
		List<Customer>cust= dao.loadCustomer();
		return cust;
		
		
	}
	public   Customer  check(String UserName ,String UserPass)
	{
		Customer   result= dao.check(UserName, UserPass);
		return result ;
		
	}
	public boolean addAmount(Integer num, Integer Id) {
		boolean status=dao.addAmount(num, Id);
		return status;
	}
	public boolean subAmount(Integer num, Integer Id) {
		boolean status=dao.subAmount(num, Id);
		return status;
	}
	public List<CustomerAccount> loadCustomerAcc(Integer Id) {
		List<CustomerAccount> CA=dao.loadCustomerAcc(Id);
		return CA;
	}
	
	

}
