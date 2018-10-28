package me.dong.springbootsimplemail.mail.gmail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * Created by huekim on 2018. 10. 27..
 */
@Component
@Slf4j
public class GMailAttachmentSender {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMessage(String to, String subject, String text, String pathToAttachment) {
        sendMessage(Collections.singletonList(to), subject, text, Collections.singletonList(pathToAttachment));
    }

    public void sendMessage(String to, String subject, String text, List<String> pathToAttachments) {
        sendMessage(Collections.singletonList(to), subject, text, pathToAttachments);
    }

    public void sendMessage(List<String> to, String subject, String text, String pathToAttachment) {
        sendMessage(to, subject, text, Collections.singletonList(pathToAttachment));
    }

    public void sendMessage(List<String> to, String subject, String text, List<String> pathToAttachments) {
        try {
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(to.toArray(new String[0]));
            messageHelper.setSubject(subject);
            messageHelper.setText(text);

            for (String pathToAttachment : pathToAttachments) {
                FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
                messageHelper.addAttachment(file.getFilename(), file);
            }

            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("fail send message - to: {}, subject: {}, text: {}, attachments: {}", to, subject, text, pathToAttachments, e);
        }
    }
}
