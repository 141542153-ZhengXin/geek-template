package com.geek.web.model.vm;

import lombok.Builder;
import lombok.Data;

/**
 * @version V1.0
 * @description: 返回结果 VM
 * @author: geek
 * @date 2021/04/11
 **/
@Data
@Builder
public class ResultVM<T> {

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 描述信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;
}
