package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tiang on 2018/7/19.
 * 登录处理器
 */
//声明是一个处理器
@Controller
public class LoginController {
//    声明访问url
    @RequestMapping("/login")
//    声明返回值直接响应给用户
    @ResponseBody
//    参数自动注入
    public String login(@RequestParam(name = "username") String id, String password){
        if(id.equals("tiang") && password.equals("12345"))
            return "success";
        else
            return "error";
    }
}
