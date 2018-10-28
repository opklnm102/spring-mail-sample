package me.dong.springbootsimplemail.mail;

/**
 * Created by huekim on 2018. 10. 27..
 */
public interface MailSender {

//    void sendMessage(String to, String subject, String text);

    void sendMessage(String subject, String text, String... to);
}
