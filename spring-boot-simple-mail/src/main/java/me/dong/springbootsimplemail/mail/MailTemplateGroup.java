package me.dong.springbootsimplemail.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

/**
 * Template Group
 * <p>
 * Created by huekim on 2018. 10. 27..
 */
@Configuration
public class MailTemplateGroup {

    @Bean
    public SimpleMailMessage simpleMessageTemplate() {
        SimpleMailMessage template = new SimpleMailMessage();
        template.setText("This is the text email template for your email: \n%s\n");
        return template;
    }
}
