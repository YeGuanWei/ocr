package com;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OcrApplication {

    private static Logger log = LogManager.getLogger(OcrApplication.class);

    public static void main(String[] args) {   // 启动时间计时
        long startTime = System.currentTimeMillis();
        // 启动项目
        SpringApplication.run(OcrApplication.class, args);
        // 输出启动时间
        log.error("启动完成，耗时：" + (System.currentTimeMillis() - startTime) / 1000.0 + "秒");
    }

}
