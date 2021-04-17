package com.geek.web.controller;

import com.geek.web.model.enums.ResultEnum;
import com.geek.web.model.vm.ResultVM;
import com.geek.web.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: Hello Controller
 * @author: geek
 * @date 2021/04/11
 **/
@RequestMapping("/hello")
@RestController
public class HelloRestController {

    @GetMapping("/getInfo/{id}")
    public ResultVM<String> getInfo(@PathVariable(value = "id") String id) {
        try {
            // todo
            // do some things
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.SERVER_ERROR.getCode(), "请求失败");
        }
        return ResultUtil.success(id);
    }
}
