package com.geek.web.controller;

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
        try {
            SysUser user = userService.getById(id);
            return ResultUtil.success(user);
        } catch (Exception e) {
            log.error("/getUser/{id}执行报错", e);
            throw e;
        }
    }
}
