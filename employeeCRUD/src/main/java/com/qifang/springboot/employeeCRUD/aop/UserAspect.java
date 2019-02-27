package com.qifang.springboot.employeeCRUD.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAspect {

	
  @AfterThrowing("execution(* com.qifang.springboot.employeeCRUD.dao.EmployeeDAOHibernateImpl.delete*(..))")
  public void doAfterThrowing() {
	  System.out.println("** AOP advice AFTER THROWING is triggered!");
  }

  @Around ("execution(* com.qifang.springboot.employeeCRUD.rest.EmployeeRestController.update*(..))")
  public void doAroundCheck(ProceedingJoinPoint pjp) {
	  System.out.println("** AOP Advice AROUND is triggered, BEFORE update execution join point **");
      try {
          pjp.proceed();
      } catch (Throwable throwable) {
          throwable.printStackTrace();
      }
      System.out.println("** AOP Advice AROUND is triggered, AFTER update execution join point**");
  }

}
