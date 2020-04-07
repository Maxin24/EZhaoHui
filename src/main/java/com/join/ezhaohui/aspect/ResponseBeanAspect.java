package com.join.ezhaohui.aspect;

import com.join.ezhaohui.utils.resultHander.CommonErrorEnum;
import com.join.ezhaohui.utils.resultHander.ResponseBean;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author:ljx
 * @Date:2020/4/7
 * @Description:
 */

@Component
@Aspect
public class ResponseBeanAspect {
    @Pointcut("execution(* com.join.ezhaohui.controller.InfoController.*(..))")
    private void infoControllerDataFormatTransition(){}

    @Around("infoControllerDataFormatTransition()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object res=proceedingJoinPoint.proceed();
        try{
            int flag=Integer.parseInt(res.toString());
            if(flag==0){
                return new ResponseBean(false,res, CommonErrorEnum.DATABASE_ERROR);
            }
            return new ResponseBean(true,res, CommonErrorEnum.SUCCESS_OPTION);
        }catch (NumberFormatException e){
            return new ResponseBean(true,res, CommonErrorEnum.SUCCESS_OPTION);
        }
    }
}
