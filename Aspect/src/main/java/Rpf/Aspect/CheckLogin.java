package Rpf.Aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CheckLogin {
	
	 @Order(1)
	 @Before(value="execution(* Rpf.Aspect.*.*(..))")
	 public void check(JoinPoint joinpoint) {
		 Date date=new Date();
		 Object[] objects=joinpoint.getArgs();
		 System.err.println(objects[0]);
		 System.err.println(joinpoint.getSignature().getName());
		 System.out.println("aop:"+new SimpleDateFormat("YYYY-MM--dd:hh:mm:ss").format(date));
	 }
	 @Order(2)
	 @Around(value="execution(* Rpf.Aspect.Login.*(..))")
	 public Object updateArgs(ProceedingJoinPoint point) throws Throwable {
		 Date date=new Date();
		 Object [] objects=point.getArgs();
		 objects[0]=5;
		
			Object re =point.proceed(objects);
		
		
		 System.out.println("aop"+new SimpleDateFormat("YYYY-MM--dd:hh:mm:ss").format(date));
		 return re;
	 }
	 @Order(4)
	 @Around(value="execution(* Rpf.Aspect.Login.*(..))")
	 public String changeReturn(ProceedingJoinPoint point) throws Throwable {
		 Object [] objects=point.getArgs();
		 System.err.println(objects[0]);
		 point.proceed();
		 return"已被AOP拦截修改";
	 }
	 @Order(3)
	 @AfterReturning(value="execution(* Rpf.Aspect.Login.*(..))",returning="re")
	 public void getRetrun(String re) {
		// TODO Auto-generated method stub
		 System.err.println(re+"------");

	}
}
