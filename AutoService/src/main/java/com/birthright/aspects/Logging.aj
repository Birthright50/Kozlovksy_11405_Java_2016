package com.birthright.aspects;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by birthright on 07.05.16.
 */
@Component
public aspect Logging {
    @Pointcut("@annotation(com.birthright.aspects.annotation.Logging)")
    public void logging() {

    }

    @Before("logging()")
    public void log(JoinPoint joinPoint) {
        Logger logger = Logger.getLogger(Logging.class);
        System.out.println("text");
        logger.log(Level.INFO, "Method Name :" + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
    }


}
