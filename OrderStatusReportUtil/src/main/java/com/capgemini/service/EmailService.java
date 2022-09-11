package com.capgemini.service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.capgemini.model.UserInfo;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

@Component
public class EmailService {
    
	
    final Configuration configuration;
    final JavaMailSender javaMailSender;
    @Autowired 
    PieChart pieChart;
    
    public EmailService(Configuration configuration, JavaMailSender javaMailSender) {
        this.configuration = configuration;
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(UserInfo user) throws MessagingException, IOException, TemplateException {
    	System.out.println("in EmailService sendEmail method");
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("Order Status Report");
        ArrayList<String> emailList=new ArrayList<String>();
        emailList.add("sumit.z.kumar@capgemini.com");
        //emailList.add("sachi.b.jain@capgemini.com");
        //emailList.add("venkata-naga-sai-hari-krishna.metlapalli@capgemini.com");
        //emailList.add("ankit.c.singhal@capgemini.com");
        //emailList.add("avinash.y.kumar@capgemini.com");
        user.setEmailList(emailList);
        user.setCount(100);
        helper.setTo(user.getEmailList().toArray(new String[0]));
        String emailContent = getEmailContent(user);
        helper.setText(emailContent, true);
        try {
			pieChart.createPieChart();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        FileSystemResource res = new FileSystemResource(new File("PieChart.jpeg"));
        helper.addInline("identifier1234", res);
        javaMailSender.send(mimeMessage);
    }

    String getEmailContent(UserInfo user) throws IOException, TemplateException {
    	System.out.println("in EmailService getEmailContent method");
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        configuration.getTemplate("email.ftlh").process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
