package com.homeTest.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;

import com.homeTest.dao.BaseDao;

@Component
@Aspect
public class MyAspectj {
	
	private Logger logger = Logger.getLogger(MyAspectj.class);
	
	@Around(value = "execution(* com.homeTest.dao.impl.ProductDaoImpl.*(..))")
	public Object around(ProceedingJoinPoint joinPoint){
		Transaction transaction = null;
		Session session = null;
		Object proceed = null;
		try {
			logger.info("准备获得session对象");
			session = BaseDao.SESSION_FACTORY.getCurrentSession();
			logger.info("成功获得session对象"+session.toString());
			logger.info("准备开启事物");
			transaction = session.beginTransaction();
			logger.info("成功开启事物");
			logger.info("准备执行方法-------"+joinPoint.getSignature().getName());
			proceed = joinPoint.proceed();
			logger.info("方法-----"+joinPoint.getSignature().getName()+"---成功执行");
			logger.info("准备提交事物");
			transaction.commit();
			logger.info("事物成功提交");
		} catch (Throwable e) {
			logger.error("方法----------"+joinPoint.getSignature().getName()+"------执行错误。");
			e.printStackTrace();
			transaction.rollback();
			logger.info("事物成功回滚");
		} 
		return proceed;
	}
	
}
