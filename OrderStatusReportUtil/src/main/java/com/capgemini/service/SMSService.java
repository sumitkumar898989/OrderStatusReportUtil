package com.capgemini.service;

import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component
public class SMSService{
	
  public  void sendSMS(){
	  
	System.out.println("in SMSService sendSMS method");
	Twilio.init(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));

    Message.creator(new PhoneNumber("+917410772589"),
                    new PhoneNumber("+18147475433"), "Order failure reached at crtical point request your attention").create();
    
}
}


