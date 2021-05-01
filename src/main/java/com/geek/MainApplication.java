package com.geek;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @version V1.0
 * @description: 启动类
 * @author: geek
 * @date 2021/04/11
 **/
@EnableOpenApi
@MapperScan("com.geek.web.dao.mapper")
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //日志输出使用异步处理，减小输出日志对性能的影响
        System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(MainApplication.class, args);
    }
}
