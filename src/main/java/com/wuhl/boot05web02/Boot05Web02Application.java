package com.wuhl.boot05web02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wuhl.boot05web02.mapper")          //直接在这里配置好之后，之后就不需要在mapper文件中再配置@Mapper
@SpringBootApplication
public class Boot05Web02Application {

    public static void main(String[] args) {
        SpringApplication.run(Boot05Web02Application.class, args);

        System.out.println("测试成功！！！");
    }



}
