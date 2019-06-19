package com.homeTest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface BaseDao {
	
	public final static Configuration configuration = new Configuration().configure();
	
	public final static SessionFactory SESSION_FACTORY = configuration.buildSessionFactory();
	
	/**
	 * Session����
	 * @return
	 */
	public Session getSession();
	
	/**
	 * ������޸�һ������
	 * @param object
	 * @return
	 */
	public void saveOrUpdate(Object object);
	
	/**
	 * ����hql����ָ����list����
	 * @param hql
	 * @param objects
	 * @return
	 */
	public List<?> queryForList(String hql,Object...objects);
	
	/**
	 * ��ҳ��ѯ
	 * @param hql
	 * @param nowPage
	 * @param pageSize
	 * @param objects
	 * @return
	 */
	public List<?> pagination(String hql,int nowPage,int pageSize,Object...objects);
	
	/**
	 * ɾ��һ������
	 * @param object
	 * @return
	 */
	public void delete(Object object);
	
	/**
	 * ����id����һ������
	 * @param class1
	 * @param id
	 * @return
	 */
	public Object get(Class<?> class1,Object id);
	
	/**
	 * ִ��HQL
	 * @param hql
	 * @param obj
	 */
	public int executeHQL(String hql,Object...args);
	
	/**
	 * ִ��SQL
	 * @param hql
	 * @param obj
	 */
	public int executeSQL(String sql,Object...args);

	/**
	 * hql��һֵ��ֵ
	 * @param hql
	 * @param args
	 * @return
	 */
	public Object uniqueQuery(String hql,Object...args);
	
	/***
	 * sql ��һֵ��ֵ
	 * @param sql
	 * @param args
	 * @return
	 */
	public Object uniqueQueryBySql(String sql,Object...args);
	
	/**
	 * ����������ѯ����List<Map>
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	public List<?> getNameQuery(String key,Object...args)throws Exception;
	/**
	 * <font color='red'>ִ��sql��䷵��list<map<String,object>></font>
	 * @param sql
	 * @param objects
	 * @return
	 */
	public List<?> executeSQLQuery(String sql ,Object...objects);
	
}
