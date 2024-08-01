package com.example.emailtemplate.repository.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import javax.mail.internet.MimeMessage;
import org.springframework.core.io.ClassPathResource;

@Service
public class EmailSenderServiceImpl{
    private static final Logger log = LoggerFactory.getLogger(EmailSenderServiceImpl.class);
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendEmailWithInlineImage(String to, String subject, Context context) {
        try {
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            String htmlContent = templateEngine.process("mail/emailTemplate", context);
            helper.setText(htmlContent, true);
            ClassPathResource imageResource = new ClassPathResource("image/abc.jpg");

            // Thêm hình ảnh đính kèm
            helper.addInline("inlineImage", imageResource, "image/jpg");

            mailSender.send(message);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }
}
