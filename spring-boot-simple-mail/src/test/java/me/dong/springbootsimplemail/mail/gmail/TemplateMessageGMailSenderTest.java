package me.dong.springbootsimplemail.mail.gmail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by huekim on 2018. 10. 28..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateMessageGMailSenderTest {

    @Autowired
    private TemplateMessageGMailSender sut;

    @Test
    public void 단일_수신자에게_전송시_성공() {
        // given :
        String to = "opklnm102@gmail.com";
        String subject = "test";
        String text = "hello";

        // when :
        sut.sendMessage(to, subject, text);

        // then :
    }

    @Test
    public void 여러_수신자에게_전송시_성공() {
        // given :
        List<String> to = Arrays.asList("opklnm102@gmail.com", "opklnm102@naver.com");
        String subject = "test";
        String text = "hello";

        // when :
        sut.sendMessage(to, subject, text);

        // when :

        // then :
    }
}