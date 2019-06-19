package com.homeTest.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.homeTest.dao.BaseDao;

@Repository("baseDaoImpl")
public class BaseDaoImpl implements BaseDao{
	
	/**
	 * Session����
	 * @return
	 */
	public Session getSession() {
		return SESSION_FACTORY.getCurrentSession();
	}
	
	/**
	 * ������޸�һ������
	 * @param object
	 * @return
	 */
	public void saveOrUpdate(Object object) {
		getSession().saveOrUpdate(object);
	}
	
	/**
	 * ����hql����ָ����list����
	 * @param hql
	 * @param objects
	 * @return
	 */
	public List<?> queryForList(String hql,Object...objects){
		Session session = getSession();
		Query createQuery = session.createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			createQuery.setParameter(i, objects[i]);
		}
		return createQuery.list();
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param hql
	 * @param nowPage
	 * @param pageSize
	 * @param objects
	 * @return
	 */
	public List<?> pagination(String hql,int nowPage,int pageSize,Object...objects){
		Session session = getSession();
		Query createQuery = session.createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			createQuery.setParameter(i, objects[i]);
		}
		createQuery.setFirstResult((nowPage-1)*pageSize);
		//ҳ���С
		createQuery.setMaxResults(pageSize);
		return createQuery.list();
	}
	
	/**
	 * ɾ��һ������
	 * @param object
	 * @return
	 */
	public void delete(Object object) {
		getSession().delete(object);
	}
	
	/**
	 * ����id����һ������
	 * @param class1
	 * @param id
	 * @return
	 */
	public Object get(Class<?> class1,Object id) {
		return getSession().get(class1, (Serializable)id);
	}
	
	/**
	 * ִ��HQL
	 * @param hql
	 * @param obj
	 */
	public int executeHQL(String hql,Object...args) {
		Query q = getSession().createQuery(hql);
		for (int i = 0; i < args.length; i++) {
			q.setParameter(i, args[i]);
		}
		return q.executeUpdate();
	}
	
	/**
	 * ִ��SQL
	 * @param hql
	 * @param obj
	 */
	public int executeSQL(String sql,Object...args) {
		Query q = getSession().createSQLQuery(sql);
		for (int i = 0; i < args.length; i++) {
			q.setParameter(i, args[i]);
		}
		return q.executeUpdate();
	}

	/**
	 * hql��һֵ��ֵ
	 * @param hql
	 * @param args
	 * @return
	 */
	public Object uniqueQuery(String hql,Object...args) {
		Query q = getSession().createQuery(hql);
		for (int i = 0; i < args.length; i++) {
			q.setParameter(i, args[i]);
		}
		return q.uniqueResult();
	}
	
	/***
	 * sql ��һֵ��ֵ
	 * @param sql
	 * @param args
	 * @return
	 */
	public Object uniqueQueryBySql(String sql,Object...args) {
		Query q = getSession().createSQLQuery(sql);
		for (int i = 0; i < args.length; i++) {
			q.setParameter(i, args[i]);
		}
		return q.uniqueResult();
	}
	/**
	 * ����������ѯ����List<Map>
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<?> getNameQuery(String key,Object...args)throws Exception{
		List<Map<String, Object>> lis = null;
		Session s = getSession();
		Query q = s.getNamedQuery(key); 
		for (int i = 0; i < args.length; i++) {
			q.setParameter(i, args[i]);
		}
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		lis = q.list();
		return lis;
	}
	/**
	 * <font color='red'>ִ��sql��䷵��list<map<String,object>></font>
	 * @param sql
	 * @param objects
	 * @return
	 */
	public List<?> executeSQLQuery(String sql ,Object...objects){
		Session s = getSession();
		Query q = s.createSQLQuery(sql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return q.list();
	}
	
}
