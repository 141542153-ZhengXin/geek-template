package com.geek.web.controller;

import com.geek.api.model.enums.ResultEnum;
import com.geek.api.model.vm.ResultVM;
import com.geek.api.util.ResultUtil;
import com.geek.web.model.entity.SysUser;
import com.geek.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @description: User Controller
 * @author: geek
 * @date 2021/04/11
 **/
@Slf4j
@RequestMapping("/user")
@RestController
public class UserRestController {

    @Resource
    private UserService userService;

    @GetMapping("/getUser/{id}")
    public ResultVM<SysUser> getUser(@PathVariable(value = "id") String id) {
        SysUser user;
        try {
            user = userService.getById(id);
        } catch (Exception e) {
            log.error("{}查询报错", "/getUser/{id}", e);
            return ResultUtil.error(ResultEnum.SERVER_ERROR.getCode(), "请求失败");
        }
        return ResultUtil.success(user);
    }
}
