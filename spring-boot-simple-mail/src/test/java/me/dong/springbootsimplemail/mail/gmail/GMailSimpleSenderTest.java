package me.dong.springbootsimplemail.mail.gmail;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Created by huekim on 2018. 10. 27..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GMailSimpleSenderTest {

    @Autowired
    private GMailSimpleSender sut;

    @Test
    public void 단일_수신자에게_전송시_성공() throws Exception {
        // given :
        String to = "opklnm102@gmail.com";
        String subject = "test";
        String text = "hello";

        // when :
        sut.sendMessage(to, subject, text);

        // then :
    }

    @Test
    public void 여러_수신자에게_전송시_성공() throws Exception {
        // given :
        List<String> to = Arrays.asList("opklnm102@gmail.com", "opklnm102@naver.com");
        String subject = "test";
        String text = "hello";

        // when :
        sut.sendMessage(to, subject, text);

        // then :
    }

    @Ignore
    @Test
    public void 여러_수신자에게_전송시_수신자가_없을_경우() throws Exception {
        // given :
        List<String> to = Collections.emptyList();
        String subject = "test";
        String text = "hello";

        // when :
        sut.sendMessage(to, subject, text);

        // then :
        // FIXME: NPE 발생
    }

    @Ignore
    @Test
    public void 여러_수신자에게_전송시_존재하지_않는_수신자일_경우() throws Exception {
        // given :
        List<String> to = Collections.singletonList("opklnm1@gmail.com"); // FIXME: 전송까지 된다 - 실제 유효 주소인지 판단할 필요 존재
        String subject = "test";
        String text = "hello";

        // when :
        sut.sendMessage(to, subject, text);

        // then :
    }

    @Ignore
    @Test
    public void 여러_수신자에게_전송시_유효하지_않은_도메인일_경우() throws Exception {
        // given :
        List<String> to = Collections.singletonList("opklnm102@n.com"); // FIXME: 전송까지 되고, DNS error mail이 온다 - 실제 유효 주소인지 판단할 필요 존재
        // DNS Error: 2439339 DNS type 'mx' lookup of n.com responded with code NXDOMAIN Domain name not found: n.com

        String subject = "test";
        String text = "hello";

        // when :
        sut.sendMessage(to, subject, text);

        // then :
    }

    @Ignore
    @Test
    public void sendMessage_발송자_지정하여_여러명에게_메일_전송() throws Exception {
        // given :
        String from = "opklnm102@gmail.com";
        List<String> to = Arrays.asList("opklnm102@gmail.com", "opklnm102@naver.com");
        String subject = "test";
        String text = "hello";

        // when :
        sut.sendMessage(from, to, subject, text);

        // then :
    }
}