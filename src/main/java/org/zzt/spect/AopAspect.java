package org.zzt.spect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * Description: AopAspect
 * date: 2020/4/18 11:06
 * author: 朱忠涛
 * version: 1.0
 */
@Component
@Aspect
public class AopAspect {

    /**
     * description: 切入点 确定哪些类所有方法被代理
     * version: 1.0
     * date: 2020/4/18 11:06
     * author: 朱忠涛
     *
     * @Param: []
     * @return: void
     */
    @Pointcut("execution(* org.zzt.demo.*.*(..))")
    public void aspectService(){}

    /**
     * description:
     * version: 1.0
     * date: 2020/4/18 11:09
     * author: 朱忠涛
     *
     * @Param: [joinPoint] 里面有代理方法信息的对象
     * @return: void
     */
    @Before("aspectService()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("目标方法名："+joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名："+joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名："+joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型："+ Modifier.toString(joinPoint.getSignature().getModifiers()));
        // 获取目标方法参数
        Object[] args = joinPoint.getArgs();
        for (int i=0;i<args.length;i++){
            System.out.println("第" + (i+1) + "个参数为:" + args[i]);
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("被代理自己:" + joinPoint.getThis().toString());
        System.out.println(joinPoint.getTarget()==joinPoint.getThis());
    }

    @Around("aspectService()")
    public Object arountMethod(ProceedingJoinPoint point){
        Object res=null;
        try {
            System.out.println("目标方法执行前");
            res = point.proceed(new Object[]{"zs"});
            System.out.println("目标方法执行后");
        } catch (Throwable throwable) {
            //异常通知
            System.out.println("执行目标方法异常后...");
            throwable.printStackTrace();
        }
        //后置通知
        System.out.println("目标方法执行后...");
        return res;
    }
}
