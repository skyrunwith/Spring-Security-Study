package com.security.sms;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class SmsController {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/sms/code")
    public void creatCode(HttpServletRequest request, HttpServletResponse response,String mobile){
        SmsCode code = new SmsCode(RandomStringUtils.random(6),60);
        sessionStrategy.setAttribute(new ServletWebRequest(request,response),"mobile",code);
        System.out.println("验证码为："+code.getCode());
    }
}
