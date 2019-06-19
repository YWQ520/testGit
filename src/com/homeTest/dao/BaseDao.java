package com.homeTest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface BaseDao {
	
	public final static Configuration configuration = new Configuration().configure();
	
	public final static SessionFactory SESSION_FACTORY = configuration.buildSessionFactory();
	
	/**
	 * Session对象
	 * @return
	 */
	public Session getSession();
	
	/**
	 * 保存或修改一个对象
	 * @param object
	 * @return
	 */
	public void saveOrUpdate(Object object);
	
	/**
	 * 根据hql返回指定的list集合
	 * @param hql
	 * @param objects
	 * @return
	 */
	public List<?> queryForList(String hql,Object...objects);
	
	/**
	 * 分页查询
	 * @param hql
	 * @param nowPage
	 * @param pageSize
	 * @param objects
	 * @return
	 */
	public List<?> pagination(String hql,int nowPage,int pageSize,Object...objects);
	
	/**
	 * 删除一个对象
	 * @param object
	 * @return
	 */
	public void delete(Object object);
	
	/**
	 * 根据id返回一个对象
	 * @param class1
	 * @param id
	 * @return
	 */
	public Object get(Class<?> class1,Object id);
	
	/**
	 * 执行HQL
	 * @param hql
	 * @param obj
	 */
	public int executeHQL(String hql,Object...args);
	
	/**
	 * 执行SQL
	 * @param hql
	 * @param obj
	 */
	public int executeSQL(String sql,Object...args);

	/**
	 * hql单一值查值
	 * @param hql
	 * @param args
	 * @return
	 */
	public Object uniqueQuery(String hql,Object...args);
	
	/***
	 * sql 单一值查值
	 * @param sql
	 * @param args
	 * @return
	 */
	public Object uniqueQueryBySql(String sql,Object...args);
	
	/**
	 * 本地命名查询返回List<Map>
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	public List<?> getNameQuery(String key,Object...args)throws Exception;
	/**
	 * <font color='red'>执行sql语句返回list<map<String,object>></font>
	 * @param sql
	 * @param objects
	 * @return
	 */
	public List<?> executeSQLQuery(String sql ,Object...objects);
	
}
