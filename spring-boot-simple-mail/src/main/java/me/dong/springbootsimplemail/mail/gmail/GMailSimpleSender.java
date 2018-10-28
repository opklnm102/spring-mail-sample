package me.dong.springbootsimplemail.mail.gmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by huekim on 2018. 10. 27..
 */
@Component
public class GMailSimpleSender {

    @Autowired
    private MailSender mailSender;

    public void sendMessage(String to, String subject, String text) {
        sendMessage(Collections.singletonList(to), subject, text);
    }

    public void sendMessage(List<String> to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to.toArray(new String[0]));
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }

    // 이건 의미가 없음... from을 바꿀 수 가 없다
    public void sendMessage(String from, List<String> to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to.toArray(new String[0]));
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}
