package com.geek.web.config;

import com.geek.api.model.enums.ResultEnum;
import com.geek.api.model.vm.ResultVM;
import com.geek.api.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version V1.0
 * @description: 全局异常处理
 * @author: geek
 * @date 2021/05/01
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVM handle(Exception e) {
        return ResultUtil.error(ResultEnum.SERVER_ERROR.getCode(), "请求失败");
    }
}
