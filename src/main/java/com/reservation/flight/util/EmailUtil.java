package com.reservation.flight.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender sender;
	private static final Logger LOGGER = LoggerFactory.getLogger(JavaMailSender.class);
	
	public void sendItinerary(String toAddress, String filePath) {
		LOGGER.info("inside sendItinerary()");
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject("Itinerary for your flight");
			messageHelper.setText("please find your Itinerary is attached");
			messageHelper.addAttachment("Invoice", new File(filePath));
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			LOGGER.error("Exception inside sendItinerary" + e);
		}
	}
}
