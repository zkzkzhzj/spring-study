package com.zkzkzhzj.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*
 * 공통 관심 사항을 분리해서 원하는 곳에 적용(시간 측정, 디버그 등)
 * 핵심 관심 사항에 불필요한 코드를 줄일 수 있음
 */
@Component
@Aspect
public class TimeTraceAop {

    // 모든 하위 패키지에 적용(모든 곳에서 시간 측정 로깅이 된다)
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}