package com.borun.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class MyJob {

    private Logger logger = LoggerFactory.getLogger(MyJob.class);

    @Scheduled(fixedRate = 1000) // 1000 ms
    public void run() {
        logger.info(String.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
}
