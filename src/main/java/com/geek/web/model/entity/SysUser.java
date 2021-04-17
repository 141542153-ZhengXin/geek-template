package com.geek.web.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @version V1.0
 * @description: User Entity
 * @author: geek
 * @date 2021/04/16
 **/
@Data
@TableName(value = "tb_user")
public class SysUser {

    @TableId(value = "id")
    private int id;

    @TableField(value = "user_name")
    private String userName;

}
