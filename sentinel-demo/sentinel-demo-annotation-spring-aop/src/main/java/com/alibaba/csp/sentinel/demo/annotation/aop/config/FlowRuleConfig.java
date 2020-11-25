package com.alibaba.csp.sentinel.demo.annotation.aop.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangfeiyang
 * @Description
 * @create 2019-12-23 17:39
 * @since 1.0-SNAPSHOT
 */
@Component
public class FlowRuleConfig implements InitializingBean {



    private void initRules(){
        FlowRule flowRule = new FlowRule();
        flowRule.setResource("DemoService.call");
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 每秒调用最大次数为 5 次
        flowRule.setCount(5);

        List<FlowRule> rules = new ArrayList<>();
        rules.add(flowRule);

        //将控制规则载入到 Sentinel
        FlowRuleManager.loadRules(rules);
    }


    @Override
    public void afterPropertiesSet(){
        initRules();
    }
}
