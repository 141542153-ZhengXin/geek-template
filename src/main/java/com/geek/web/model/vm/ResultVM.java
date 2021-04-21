package com.geek.web.model.vm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @version V1.0
 * @description: 返回结果 VM
 * @author: geek
 * @date 2021/04/11
 **/
@ApiModel("返回响应数据")
@Data
@Builder
public class ResultVM<T> {

    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码")
    private Integer status;

    /**
     * 描述信息
     */
    @ApiModelProperty(value = "描述信息")
    private String message;

    /**
     * 数据
     */
    @ApiModelProperty(value = "数据")
    private T data;
}
