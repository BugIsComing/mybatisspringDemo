package com.lc.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class BaseDao extends SqlSessionDaoSupport {

	public void save(String key, Object object){
		getSqlSession().insert(key, object);
	}
	
	public void update(String key, Object object){
		getSqlSession().update(key, object);
	}
	
	public void update(String key){
		getSqlSession().update(key);
	}
	
	public void delete(String key, Serializable id) {
		getSqlSession().delete(key, id);
	}
	
	public void delete(String key, Object object){
		getSqlSession().delete(key, object);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String key, Object object){
		 T t = (T)getSqlSession().selectOne(key, object);
		 getSqlSession().clearCache();
		 return t;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getList(String key){
		return getSqlSession().selectList(key);
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getList(String key, Object object){
		return getSqlSession().selectList(key, object);
	}
}
