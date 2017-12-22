package com.yyc.my_pro.aspect_log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

//日志
//AOP切面监控日志
@Aspect
@Component
public class m_log {
    private static final Logger logger = LoggerFactory.getLogger(m_log.class);
    private double time;
    //此处指定了改方法的调用时间
    @Before("execution(* com.yyc.my_pro.controller.*Controller.*(..))")
    //不太懂这几个什么意思
    //JoinPoint 切点，内容可以显示
    public void BeforeMethod(JoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : joinPoint.getArgs() ) {
            sb.append("args" + obj.toString() + "|");
        }
        time = new Date().getTime();
        logger.info("Before Method: " + sb.toString() + new Date());
    }

    @After("execution(* com.yyc.my_pro.controller.*Controller.*(..))")
    public void AfterMethod(JoinPoint joinPoint) {
        logger.info("After Method" + new Date());
        logger.info(String.format("Spend: %s" , (new Date()).getTime() - time));
    }
}
