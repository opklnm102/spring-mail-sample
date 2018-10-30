package me.dong.springbootsimplemail.mail.gmail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by huekim on 2018. 10. 30..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GMailTemplateSenderTest {

    @Autowired
    private GMailTemplateSender sut;

    @Test
    public void sendMessage() {
        // given :
        List<String> to = Arrays.asList("opklnm102@gmail.com", "opklnm102@naver.com");
        String subject = "attachment test";
        String text = "hello";

        // when :
        sut.sendMessage(to, subject, text);

        // then :
    }

    @Test
    public void generateTemplate() {
    }
}