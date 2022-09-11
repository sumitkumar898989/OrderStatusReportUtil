package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.model.UserInfo;
import com.capgemini.service.EmailService;

@Component
public class EmailSenderController {
	
	@Autowired 
	EmailService emailService;
	@Autowired 
	UserInfo userInfo;
	
	
	public void execute( ) throws Exception {
		System.out.println("in EmailSenderController execute method");
	    emailService.sendEmail(userInfo);
	}

}
