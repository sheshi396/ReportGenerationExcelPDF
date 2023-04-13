package com.Spring.util;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
@Component
public class EmailUtils {
	@Autowired
	 private  JavaMailSender mailSender;

	   

	    public boolean sendEmail(String to, String subject, String body,File f) throws Exception {
	       try { 
	    	MimeMessage mimeMessage = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.addAttachment("plansInfo", f);
	        
	        helper.setText(body, true);
	        mailSender.send(mimeMessage);
	       } catch(Exception e) {
	    	   e.printStackTrace();
	       }
	    return true;
	
	    }
}
