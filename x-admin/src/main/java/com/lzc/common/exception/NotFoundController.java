package com.lzc.common.exception;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotFoundController implements ErrorController {


    @GetMapping("/error")
    public String erorr404(){
        return "/error/404";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
