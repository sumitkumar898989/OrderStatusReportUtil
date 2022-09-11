package com.capgemini.service;

import com.textmagic.sdk.RestClient;
import com.textmagic.sdk.RestException;
import com.textmagic.sdk.resource.instance.*;
import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class SMSService{
	
  public  void sendSMS() throws RestException {
	  
	  System.out.println("in SMSService sendSMS method");
    RestClient client = new RestClient("<username>", "<apiv2_key>");
    TMNewMessage m = client.getResource(TMNewMessage.class);
    m.setText("Hello from TextMagic Java");
    m.setPhones(Arrays.asList(new String[] {"7410772589"}));
    try {
      m.send();
    } catch (final RestException e) {
      System.out.println(e.getErrors());
      throw new RuntimeException(e);
    }
    System.out.println(m.getId());
  }
}

