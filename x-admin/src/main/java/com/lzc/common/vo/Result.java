package com.lzc.common.vo;

import lombok.Data;

@Data

public class Result<T> {
    private Integer code;//返回码
    private String message;//描述
    private T data; //返回数据
    private Long count;//分页查询

    private Result(){};

    public Result(Integer code, String message, T data, Long count) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    public static Result<Object> success(){
        return new Result(0,"success",null,null);
    }
    public static Result<Object> success(String msg){
        return new Result(0,msg,null,null);
    }

    public static Result<Object> success(Object data,Long count){
        return new Result(0,"success",data,count);
    }


    public static Result<Object> fail(String msg){
        return new Result(-1,msg,null,null);
    }
}
