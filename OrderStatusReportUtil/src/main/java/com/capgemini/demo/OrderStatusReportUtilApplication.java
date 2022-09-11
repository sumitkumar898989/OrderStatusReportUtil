package com.capgemini.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.capgemini.controller.EmailSenderController;
import com.capgemini.service.SMSService;


@SpringBootApplication
@ComponentScan(basePackages = {"com.capgemini.controller","com.capgemini.service","com.capgemini.model"})
public class OrderStatusReportUtilApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(OrderStatusReportUtilApplication.class, args);
		System.out.println("Application getting started");
		EmailSenderController e = context.getBean(EmailSenderController.class);
		//SMSService s = context.getBean(SMSService.class);
		try {
			e.execute();
			System.out.println("Email Sent");
			//s.sendSMS();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
