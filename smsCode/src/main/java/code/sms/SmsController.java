package code.sms;

import code.valid.ImageCode;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServicePermission;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@RestController
public class SmsController {

    public final static String SESSION_KEY_SMS_CODE = "SESSION_KEY_SMS_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/sms/code")
    public void createCode(HttpServletRequest request, HttpServletResponse response, String mobile) throws IOException {
        SmsCode code = createSmsCode();
        sessionStrategy.setAttribute(new ServletWebRequest(request,response),SESSION_KEY_SMS_CODE+mobile,code);

//        邮件功能，没有接口
        System.out.println("验证码为："+code.getCode());
    }

    private SmsCode createSmsCode() {
        String code = RandomStringUtils.random(6);
        return new SmsCode(code,60);
    }
}
