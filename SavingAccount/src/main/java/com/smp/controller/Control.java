package com.smp.controller;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.smp.Service.CustomService;
import com.smp.model.Customer;
import com.smp.model.CustomerAccount;


@Controller
@SessionAttributes({"id","name"})
public class Control 
{  
	@Autowired
	private CustomService main; 
	
	

	@RequestMapping(value="/reg.sp")
	public String getData(@ModelAttribute Customer cust,Model model)
	{
		main.createCustomer(cust);		
		model.addAttribute("msg", cust.getName());
		return "show";
		
	}
 
	@RequestMapping("/list.sp")
	public String  list(ModelMap model)
	{ 
    	List<Customer>cust=main.getCustomer();

		model.addAttribute(cust);
		
		 model.put("msg",cust);

	  
		return "showlist";
		
	}
    
	@RequestMapping(path="/log.sp")
	public  ModelAndView checkData(@RequestParam ("uname")String UserName,@RequestParam("pass")String UserPass,Model model )
	{     
		ModelAndView mvc=new ModelAndView("Transfer");
		Customer  result=main.check(UserName,UserPass);
		
		 if(result.getId()==0 && result.getName()==null)
		 {
			 ModelAndView mvc1=new ModelAndView("error");
				
			 mvc1.addObject("msg","wrong username and password");
			return mvc1;
			 
		 }
		 else {
			
		
			 mvc.addObject("id",result.getId());
	
			 mvc.addObject("name",result.getName());
			 mvc.addObject("msg","Successful Login");
			 System.out.println(result.getId());
	         model.addAttribute("id", result.getId());
			 
			return mvc;
		
		 } 	
	}

	@RequestMapping("/cradit.sp")
	public ModelAndView craditAmount(@RequestParam("num")Integer Num,Model model1)
	{   
		ModelAndView mvc=new ModelAndView("Transfer");
		Integer Id=(Integer) model1.getAttribute("id");
		String name=(String) model1.getAttribute("name");
		System.out.println("Cradit Amount="+Num);
		boolean status=main.addAmount(Num, Id);
		System.out.println(status);
		if(status==true)
		{
		 mvc.addObject("name",name);
		 mvc.addObject("msg"," Cradit Amount Successful");
		
		}
		else {
			 mvc.addObject("name",name);
			 mvc.addObject("msg"," Cradit Amount failed");
		}
		return mvc;
	}
	
	@RequestMapping("/debit.sp")
	public ModelAndView   debitAmount(@RequestParam("num")Integer Num,Model model2)
	{
		ModelAndView mvc=new ModelAndView("Transfer");
		Integer Id=(Integer) model2.getAttribute("id");
		String name=(String) model2.getAttribute("name");
		System.out.println("Debited Amount="+Num);
		boolean status=main.subAmount(Num, Id);
		System.out.println(status);
		if(status==true)
		{
		 mvc.addObject("name",name);
		 mvc.addObject("msg"," Debited Amount Successful");
		
		}
		else {
			 mvc.addObject("name",name);
			 mvc.addObject("msg"," Debited Amount failed");
		}
		return mvc;
		
	}
	@RequestMapping(path="/logout.sp")
	public String  Log(SessionStatus status)
	{
		status.setComplete();
		return "NewFile";
		
	}
	@RequestMapping(path="/trans.sp")
	public String  Trans(ModelMap model)
	{  
		Integer Id=(Integer) model.getAttribute("id");
      List<CustomerAccount> CA=main.loadCustomerAcc(Id);
       model.addAttribute(CA);
       model.put("msg", CA);
		return "showlist";
		
	}
	
}
