package com.geek.web.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @description: Result Enum
 * @author: geek
 * @date 2021/04/11
 **/
@Getter
@AllArgsConstructor
public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(),"请求失败"),
    SUCCESS(HttpStatus.OK.value(), "请求成功");
    private Integer code;
    private String msg;
}
