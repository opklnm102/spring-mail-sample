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
public class GMailSimpleInlineSenderTest {

    @Autowired
    private GMailSimpleInlineSender sut;

    @Test
    public void 단일_수신자에게_단건의_첨부파일_전송시_성공() {
        // given :
        String to = "opklnm102@gmail.com";
        String subject = "attachment test";
        String text = "hello";
        String pathToAttachment = "/Users/huekim/Desktop/pod_example1.png";

        // when :
        sut.sendMessage(to, subject, text, pathToAttachment);

        // then :
    }

    @Test
    public void 단일_수신자에게_다건의_첨부파일_전송시_성공() {
        // given :
        String to = "opklnm102@gmail.com";
        String subject = "attachment test";
        String text = "hello";
        List<String> pathToAttachments = Arrays.asList("/Users/huekim/Desktop/pod_example1.png",
                "/Users/huekim/Desktop/istio_overview.png");

        // when :
        sut.sendMessage(to, subject, text, pathToAttachments);

        // then :
    }

    @Test
    public void 여러_수신자에게_단건의_첨부파일_전송시_성공() {
        // given :
        List<String> to = Arrays.asList("opklnm102@gmail.com", "opklnm102@naver.com");
        String subject = "attachment test";
        String text = "hello";
        String pathToAttachment = "/Users/huekim/Desktop/pod_example1.png";

        // when :
        sut.sendMessage(to, subject, text, pathToAttachment);

        // then :
    }

    @Test
    public void 여러_수신자에게_다건의_첨부파일_전송시_성공() {
        // given :
        List<String> to = Arrays.asList("opklnm102@gmail.com", "opklnm102@naver.com");
        String subject = "attachment test";
        String text = "hello";
        List<String> pathToAttachments = Arrays.asList("/Users/huekim/Desktop/pod_example1.png",
                "/Users/huekim/Desktop/istio_overview.png");

        // when :
        sut.sendMessage(to, subject, text, pathToAttachments);

        // then :
    }
}