package com.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @description: ${description}
 * @author: xianglong
 * @create: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 **/
@ServletComponentScan
@SpringBootApplication(scanBasePackages = "com.cas")
public class JustAuthApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(JustAuthApplication.class, args);
            System.out.println("测试环境启动成功！！！！");
        } catch (Exception e) {
            System.out.println("测试环境启动失败！！！！");
        }
    }

}