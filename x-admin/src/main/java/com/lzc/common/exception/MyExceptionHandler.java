package com.lzc.common.exception;


import com.lzc.common.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
    @ResponseBody
    @ExceptionHandler()
    public Result<Object> exception404(Exception e){
        return Result.fail("系统异常:"+e.getMessage());
    }
}
