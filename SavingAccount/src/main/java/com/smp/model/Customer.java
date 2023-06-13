package com.smp.model;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
@Entity
public class Customer 
{

   @Id
  @GeneratedValue(generator = "sequence-generator")
  @GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
  parameters= {
  		@Parameter(name = "sequence_name", value = "cust_sequence"),
          @Parameter(name = "initial_value", value = "1"),
          @Parameter(name = "increment_size", value = "1")		
  })
	private int Id;
   @Column (name="CustomerName")
 	private String name;
    private Date date = new Date();
	@Column(name="MobileNo")
	private String num;
	@Column(name="TotalBalance")
   private  long totalBalance=0000;
	@Column(name="Username")
	private String uname;
	@Column(name="Password")
	private String pass;
//	@OneToMany(cascade=CascadeType.ALL)
//	private List<CustomerAccount> custCradit;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public long getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(long totalBalance) {
		this.totalBalance = totalBalance;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", name=" + name + ", date=" + date + ", num=" + num + ", totalBalance="
				+ totalBalance + ", uname=" + uname + ", pass=" + pass + "]";
	}
	
	
}
