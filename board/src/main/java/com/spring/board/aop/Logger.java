package com.spring.board.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
@Aspect
public class Logger {
    /* TODO
    point Cut과 Around를 사용하여 Controller의 각 API가 실행하는 시간을 로깅 출력
     */
    @Pointcut("execution(* com.spring.board.controller.BoardController.*(..))")
    public void BoardController() {

    }
    @Around("BoardController()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
        String nowTime = dateFormat.format(now);
        Object object = joinPoint.proceed();
        System.out.println(nowTime);
        return object;
    }
}





