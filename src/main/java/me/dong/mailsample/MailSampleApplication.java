package me.dong.mailsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * https://www.baeldung.com/spring-email
 */
@SpringBootApplication
public class MailSampleApplication {

    /*
    MailSender
        기본적인 mail 전송 기능을 제공하는 interface
    JavaMailSender
        MIME message 지원
        MIME message 생성을 위해 MimeMessageHelper와 함께 사용
        이 interface로 MimeMessagePreparator mechanism를 사용하는게 좋다
    JavaMailSenderImpl
        JavaMailSender 구현체
        MimeMessage, SimpleMailMessage 지원
    SimpleMailMessage
        from, to, cc, subject, text 필드를 포함한 간단한 메일 메시지 생성시 사용
    MimeMessagePreparator
        MIME message 준비를 위한 callback 제공
    MimeMessageHelper
        MIME message 생성을 위한 helper class
        HTML layout에서 image, 첨부, 텍스트 컨텐츠 지원
     */

    public static void main(String[] args) {
        SpringApplication.run(MailSampleApplication.class, args);
    }
}
