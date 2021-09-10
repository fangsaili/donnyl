package com.example.wiki.config;

import com.example.wiki.controller.ControllerExceptionHandler;
import com.example.wiki.mapper.WatchtimesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class SchedularTask {
    @Resource
    private WatchtimesMapper watchtimesMapper;


    private static final Logger Log = LoggerFactory.getLogger(ControllerExceptionHandler.class);



    @Scheduled(cron = "0 0 0 * * ?") //每10秒执行一次
    public void scheduledTaskByCorn() {
        Log.info("--------------定时任务开始 ByCorn：" + System.currentTimeMillis());
        watchtimesMapper.clearwatchtimes();
        Log.info("--------------定时任务结束 ByCorn：" + System.currentTimeMillis());
    }


    private void scheduledTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
