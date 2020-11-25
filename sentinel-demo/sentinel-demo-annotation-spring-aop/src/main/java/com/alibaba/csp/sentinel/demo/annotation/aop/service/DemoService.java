package com.alibaba.csp.sentinel.demo.annotation.aop.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangfeiyang
 * @Description
 * @create 2019-12-23 17:17
 * @since 1.0-SNAPSHOT
 */
@Service
public class DemoService {

    private final AtomicInteger counter = new AtomicInteger();

    @SentinelResource(value = "DemoService.call", blockHandler = "callBlocked")
    public void call() {
        System.out.println("Hello (" + counter.getAndIncrement() + ")");
    }

    public void callBlocked(BlockException ex) {
        System.err.println("Blocked (" + counter.getAndIncrement() + ") : " + ex.toString());
    }
}
