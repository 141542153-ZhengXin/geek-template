package com.geek.web.util;

import com.geek.web.model.enums.ResultEnum;
import com.geek.web.model.vm.ResultVM;

/**
 * @description: Result 工具类
 * @author: geek
 * @date 2021/04/11
 **/
public class ResultUtil {
    public static <T> ResultVM<T> success(T object) {
        return ResultVM.<T>builder().
                status(ResultEnum.SUCCESS.getCode()).
                message(ResultEnum.SUCCESS.getMsg()).
                data(object).
                build();
    }

    public static <T> ResultVM<T> success() {
        return success(null);
    }

    public static <T> ResultVM<T> error(Integer code, String msg) {
        return ResultVM.<T>builder().
                status(code).
                message(msg).
                build();
    }

    public static <T> ResultVM<T> error(ResultEnum resultEnum) {
        return error(resultEnum.getCode(), resultEnum.getMsg());
    }

}
