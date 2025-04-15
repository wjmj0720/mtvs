package com.ohgiraffers.aop.section02.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    @Around(
            "execution(* com.ohgiraffers.aop.section02.MemberService.register*(..)) ||" +
             "execution(* com.ohgiraffers.aop.section02.MemberService.delete*(..)) ||" +
             "execution(* com.ohgiraffers.aop.section02.MemberService.update*(..))"
    )
    public Object manageTransaction(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();

        try{
            System.out.println("[트랜젝션] : "+methodName+"트랜잭션 시작");
            Object result = joinPoint.proceed();
            System.out.println("[트랜잭션] : "+methodName +"트랜잭션 커밋");
            return result;
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println("[트랜잭션] : "+methodName +"트랜잭션 롤백" );
            return null;
        }
    }
}
