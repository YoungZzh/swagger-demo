package com.itheima.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Author:Young
 * Date:2020/7/20-22:22
 */
@ApiModel("用户实体类")
public class User {

    @ApiModelProperty("账户")
    public String username;

    @ApiModelProperty("密码")
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
