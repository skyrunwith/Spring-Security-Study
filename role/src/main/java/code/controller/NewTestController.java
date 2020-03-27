package code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class NewTestController {

    @RequestMapping("test")
    public String test(){
        return "/login.html";
    }
}
