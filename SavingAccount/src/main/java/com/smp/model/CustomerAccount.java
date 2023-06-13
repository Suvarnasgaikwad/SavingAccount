package com.smp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
public class CustomerAccount 
{    
	@Id
	 @GeneratedValue(generator = "sequence-generator")
	  @GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	  parameters= {
	  		@Parameter(name = "sequence_name", value = "CA_sequence"),
	          @Parameter(name = "initial_value", value = "1"),
	          @Parameter(name = "increment_size", value = "1")		
	  })
	private int No;
	private int Id;
	private Date date=new Date();
	private long DebitAmount;
	private long craditAmount;
	private long totalBalance;
	
	public long getDebitAmount() {
		return DebitAmount;
	}
	public void setDebitAmount(long debitAmount) {
		DebitAmount = debitAmount;
	}
	public long getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(long totalBalance) {
		this.totalBalance = totalBalance;
	}
	
	public long getCraditAmount() {
		return craditAmount;
	}
	public void setCraditAmount(long craditAmount) {
		this.craditAmount = craditAmount;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "CustomerAccount [Id=" + Id + ", date=" + date + ", DebitAmount=" + DebitAmount + ", craditAmount="
				+ craditAmount + ", totalBalance=" + totalBalance + "]";
	}
	
	
}
