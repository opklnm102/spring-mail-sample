package me.dong.springbootsimplemail.mail.gmail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Enterprise Application에서는 아래와 같은 방법으로 Template을 랜더링하지 않는 이유
 * 1. Java로 HTML Content 생성시 오류가 발생하기 쉽다
 * 2. Display logic과 Business logic이 혼재
 * 3. HTML Content 수정시 re bulid 필요
 * <p>
 * 그래서 FreeMarker와 같은 template library 사용
 * - 코드에서 랜더링할 데이터를 만들고, 전송하는 작업만 수행
 * <p>
 * Created by huekim on 2018. 10. 28..
 */
@Component
@Slf4j
public class GMailSimpleInlineSender {

    private final JavaMailSender mailSender;

    private final String templateLayout = "<html><body>%s</body></html>";

    private final String templateContentLayout = "<img src='cid:%s'>";

    public GMailSimpleInlineSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

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

            List<FileSystemResource> resources = new ArrayList<>();
            StringBuilder content = new StringBuilder(text);
            for (String pathToAttachment : pathToAttachments) {
                FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
                resources.add(file);
                content.append(String.format(templateContentLayout, file.getFilename()));
            }

            messageHelper.setText(String.format(templateLayout, content.toString()), true);

            for (FileSystemResource file : resources) {
                messageHelper.addInline(file.getFilename(), file);
            }

            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("fail send message - to: {}, subject: {}, text: {}, attachments: {}", to, subject, text, pathToAttachments, e);
        }
    }
}




