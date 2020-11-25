package com.alibaba.csp.sentinel.demo.annotation.aop;

import com.alibaba.csp.sentinel.demo.annotation.aop.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author wangfeiyang
 * @Description
 * @create 2019-12-23 17:20
 * @since 1.0-SNAPSHOT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SentinelTestApplication {

    @Resource
    private DemoService demoService;


    @Test
    public void run() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            Thread.sleep(100);
            demoService.call();
        }
        Thread.sleep(1000);
        for (int i = 0; i < 50; i++) {
            Thread.sleep(100);
            demoService.call();
        }
    }
}
