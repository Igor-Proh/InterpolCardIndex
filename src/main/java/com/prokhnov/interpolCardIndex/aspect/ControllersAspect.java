package com.prokhnov.interpolCardIndex.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * The {@code ControllersAspect} class.<br/>
 * Aspects configuration class
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Component
@Aspect
public class ControllersAspect {

    private static final Logger LOGGER = Logger.getLogger(ControllersAspect.class.getName());

    private final String ARR = " >>> ";

    @Before("execution(public String save* (..))")
    public void logBeforeSave(JoinPoint joinPoint) {
        LOGGER.info(joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Before("execution(public String update* (..))")
    public void logBeforeUpdate(JoinPoint joinPoint) {
        LOGGER.info(joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Before("execution(public String delete* (..))")
    public void logBeforeDelete(JoinPoint joinPoint) {
        LOGGER.info(joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }
}
