package com.capgemini.service;

import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component
public class SMSService{
	
  public  void sendSMS(){
	  
	System.out.println("in SMSService sendSMS method");
	Twilio.init("AC5ef8252f9f7ae2dba8c8b184ed3a4d3f","1da592e9aa0d6a74831bcc72f4748f29");

    Message.creator(new PhoneNumber("+917410772589"),
                    new PhoneNumber("+18147475433"), "Order failure reached at crtical point request your attention").create();
    
}
}


