package com.geek.web.controller;

import com.geek.api.model.enums.ResultEnum;
import com.geek.api.model.vm.ResultVM;
import com.geek.api.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version V1.0
 * @description: Hello Controller
 * @author: geek
 * @date 2021/04/11
 **/
@Api(tags = "hello接口")
@Slf4j
@RequestMapping("/hello")
@RestController
public class HelloRestController {

    @ApiOperation(value = "根据id获取信息")
    @GetMapping("/getInfo/{id}")
    public ResultVM<String> getInfo(@ApiParam(name = "id") @PathVariable(value = "id") String id) {
        try {
            return ResultUtil.success(id);
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.SERVER_ERROR.getCode(), "请求失败");
        }
    }
}
