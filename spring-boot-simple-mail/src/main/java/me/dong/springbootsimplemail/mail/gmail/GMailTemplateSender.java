package me.dong.springbootsimplemail.mail.gmail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by huekim on 2018. 10. 30..
 */
@Component
@Slf4j
public class GMailTemplateSender {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendMessage(List<String> to, String subject, String text) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(to.toArray(new String[0]));
            messageHelper.setSubject(subject);
            messageHelper.setText(generateTemplate(subject, text), true);

            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("fail send message - to: {}, subject: {}, text: {}", to, subject, text, e);
        }
    }

    public String generateTemplate(String subject, String text) {
        Context context = new Context();
        context.setVariable("title", subject);
        context.setVariable("content", text);
        context.setVariable("createdAt", LocalDateTime.now());

        return templateEngine.process("mail/simple_mail", context);
    }
}