package com.lzc.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page implements Serializable {
    private Integer page;
    private Integer limit;

    public Long getStart(){ //获取第n页的数据
        return (page-1L)*limit;
    }
}
