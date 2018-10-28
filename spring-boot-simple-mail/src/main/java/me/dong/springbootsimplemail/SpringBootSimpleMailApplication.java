package me.dong.springbootsimplemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * https://www.baeldung.com/spring-email
 * https://docs.spring.io/spring/docs/5.0.10.RELEASE/spring-framework-reference/integration.html#mail
 */
@SpringBootApplication
public class SpringBootSimpleMailApplication {

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

    ## MailSendException
        잘못된 주소로 전송하는 동안 발생하지 않을 수 있다
        RFC 821의 SMTP protocol spec에서는 잘못된 주소로 메일을 보낼 때 550 code를 반환하도록 정의
            대부분의 공용 SMTP 서버는 수행하지 않는다
            delivery failed mail을 보내주거나 피드백을 주지 않는다
        GMail - exception catch 처리를 하고, 주기적으로 delivery failed mail을 확인
        AWS SES - Bounce Rate가 높으면 계정이 차단되기 때문에 관리 필요
     */

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSimpleMailApplication.class, args);
    }
}
