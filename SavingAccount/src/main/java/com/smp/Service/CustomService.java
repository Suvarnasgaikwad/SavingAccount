package com.smp.Service;

import java.util.List;

import com.smp.model.Customer;
import com.smp.model.CustomerAccount;

public interface CustomService 
{
	public void createCustomer(Customer cust);
	public 	List<Customer> getCustomer();
	public Customer check(String UserName ,String UserPass);
	public boolean addAmount(Integer num,Integer Id);
	public boolean subAmount(Integer num,Integer Id);
	 public List<CustomerAccount> loadCustomerAcc(Integer Id);
	
}
