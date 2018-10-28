package me.dong.springbootsimplemail.mail.gmail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by huekim on 2018. 10. 28..
 */
@Component
public class TemplateMessageGMailSender {

    private final MailSender mailSender;

    private final SimpleMailMessage template;

    public TemplateMessageGMailSender(MailSender mailSender, SimpleMailMessage template) {
        this.mailSender = mailSender;
        this.template = template;
    }

    public void sendMessage(String to, String subject, String text) {
        sendMessage(Collections.singletonList(to), subject, text);
    }

    public void sendMessage(List<String> to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to.toArray(new String[0]));
        message.setSubject(subject);
        message.setText(String.format(template.getText(), text));

        mailSender.send(message);
    }
}
