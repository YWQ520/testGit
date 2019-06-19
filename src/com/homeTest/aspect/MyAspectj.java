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
			logger.info("׼�����session����");
			session = BaseDao.SESSION_FACTORY.getCurrentSession();
			logger.info("�ɹ����session����"+session.toString());
			logger.info("׼����������");
			transaction = session.beginTransaction();
			logger.info("�ɹ���������");
			logger.info("׼��ִ�з���-------"+joinPoint.getSignature().getName());
			proceed = joinPoint.proceed();
			logger.info("����-----"+joinPoint.getSignature().getName()+"---�ɹ�ִ��");
			logger.info("׼���ύ����");
			transaction.commit();
			logger.info("����ɹ��ύ");
		} catch (Throwable e) {
			logger.error("����----------"+joinPoint.getSignature().getName()+"------ִ�д���");
			e.printStackTrace();
			transaction.rollback();
			logger.info("����ɹ��ع�");
		} 
		return proceed;
	}
	
}
