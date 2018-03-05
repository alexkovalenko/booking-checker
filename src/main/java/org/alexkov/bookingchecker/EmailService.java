package org.alexkov.bookingchecker;

import org.alexkov.bookingchecker.dto.EMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(final EMail EMail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(EMail.getSubject());
        message.setText(EMail.getContent());
        message.setTo(EMail.getTo().split(","));
        message.setFrom(EMail.getFrom());
        emailSender.send(message);
    }
}
