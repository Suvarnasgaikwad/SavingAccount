package com.smp.Dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.dialect.Ingres10Dialect;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.smp.model.Customer;
import com.smp.model.CustomerAccount;

@Transactional
@Repository
public class Custmerdao implements DataObj
{  
	@Autowired
	private SessionFactory s;
	
	@Autowired
     private HibernateTemplate hibernateTemplate;
 
	public void saveCustomer(Customer cust)
     {
    	hibernateTemplate.saveOrUpdate(cust);
 	 
     }
	
	@SuppressWarnings("deprecation")
	public 	List<Customer> loadCustomer()
    {
	
		List list=hibernateTemplate.find("select Id, name, date,totalBalance from Customer");
		List<Customer>cust=new ArrayList<Customer>();
		for(int i=0;i<list.size();i++)
		{
			Customer c=new Customer();
			Object[]obj=(Object[]) list.get(i);
			int id=(Integer) obj[0];
			c.setId(id);
			String name=(String) obj[1];
			c.setName(name);
			Date date=(Date) obj[2];
		   c.setDate(date);
			Long Balance =(Long) obj[3];
			c.setTotalBalance(Balance);
			cust.add(c);
			
		}
		return cust;
    	
    }
	
	
	@SuppressWarnings("deprecation")
	public    Customer  check(String UserName ,String UserPass)
	{
		Customer c=new Customer();
	
		  System.out.println("Customer id is=");
		  Object[] param=new Object[] {UserName,UserPass};
		  String SQL_QUERY =" select Id,name from Customer as c where c.uname=?0 and c.pass=?1";
		  List list=hibernateTemplate.find(SQL_QUERY,param );
		  if( (list !=null) &&(list.size()>0))
          {
			for(int i=0;i<list.size();i++)
			{    
				
				Object[]obj=(Object[]) list.get(i);
				int id=(Integer) obj[0];
     			c.setId(id);
				String name=(String) obj[1];
			     c.setName(name);
			

			}
 
          }
			return  c;
		
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public boolean addAmount(Integer craditAmount, Integer Id) 
	{   
		long DebitAmount=0;
		CustomerAccount CA=new CustomerAccount();
		boolean status=false;
		  String SQL_QUERY =" select totalBalance from Customer as c where c.Id=?0";
		  List list=hibernateTemplate.find(SQL_QUERY,Id );
		  if( (list !=null) &&(list.size()>0))
		  {for(int i=0;i<list.size();i++)
			{    
				Long TB= (Long) list.get(i);
				Long TotalBalance=TB+craditAmount;
				CA.setId(Id);
				CA.setCraditAmount(craditAmount);
				CA.setDebitAmount(DebitAmount);
      			CA.setTotalBalance(TotalBalance);
			 
			    int Id1= (Integer) hibernateTemplate.save(CA);
				Session s1=s.openSession();
				Transaction tx=s1.beginTransaction();
				Query query=s1.createQuery("update Customer c set c.totalBalance="+TotalBalance+" where c.Id=:D");
			   query.setParameter("D", Id);
				int num1=query.executeUpdate();
				tx.commit();
				if(num1==1 && Id1!=0)
				{
					status=true;
				}
				 
			}
		  
		  }
		 
		return status;
	}

	public boolean subAmount(Integer num, Integer Id) 
	{     long craditAmount=0;
	     CustomerAccount CA=new CustomerAccount();
		boolean status=false;
		  String SQL_QUERY =" select totalBalance from Customer as c where c.Id=?0";
		  List list=hibernateTemplate.find(SQL_QUERY,Id );
		  if( (list !=null) &&(list.size()>0))
		  {for(int i=0;i<list.size();i++)
			{    
				
				Long TB= (Long) list.get(i);
				Long TotalBalance=TB-num;
				 CA.setId(Id);
				CA.setCraditAmount(craditAmount);
				CA.setDebitAmount(num);
      			CA.setTotalBalance(TotalBalance);
			   
			    int Id1= (Integer) hibernateTemplate.save(CA);
			    System.out.println(Id1);
				Session s1=s.openSession();
				Transaction tx=s1.beginTransaction();
				Query query=s1.createQuery("update Customer c set c.totalBalance="+TotalBalance+" where c.Id=:D");

			   query.setParameter("D", Id);
				int num1=query.executeUpdate();
				tx.commit();
				if(num1==1 && Id1!=0)
				{
					status=true;
				}
			     
			}
		  
		  }
		 
		return status;
	}

	@SuppressWarnings("deprecation")
	public List<CustomerAccount> loadCustomerAcc(Integer Id) 
	{
		Session s1=s.openSession();
		Transaction tx=s1.beginTransaction();
		Query query=s1.createQuery("from CustomerAccount as c where c.Id=?0 ");
		 query.setParameter(0, Id);
		 List<CustomerAccount> list= query.list();
		 for(CustomerAccount ca:list)
		 {
			 System.out.println(ca.getTotalBalance()+":"+ca.getId());
		 }
		return list;
		
}
}