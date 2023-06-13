package com.smp.Dao;

import java.util.List;

import com.smp.model.Customer;
import com.smp.model.CustomerAccount;

public interface DataObj
{
     public void saveCustomer(Customer cust);
     public List<Customer> loadCustomer();
     public  Customer check(String UserName ,String UserPass);
     public boolean addAmount(Integer num,Integer Id);
     public boolean subAmount(Integer num,Integer Id);
     public List<CustomerAccount> loadCustomerAcc(Integer Id);
}
