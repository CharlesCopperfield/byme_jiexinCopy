package cn.itcast.jk.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.BaseDao;

/** 
 * BaseDao的实现类.实现了基本的增删改查功能
 * 子类继承此类时,需要传入mapper中的namespace.
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 上午7:49:27    
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	public void setSqlSessionFactr(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private String nameSpace;
	protected BaseDaoImpl(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	@Override
	public List<T> findAll() {
		SqlSession session = sessionFactory.openSession(true);
		return session.selectList(nameSpace+".findAll");
	}

	@Override
	public T findById(String id) {
		SqlSession session = sessionFactory.openSession(true);
		return session.selectOne(nameSpace+".findById",id);
	}

	@Override
	public int deleteById(String id) {
		SqlSession session = sessionFactory.openSession(true);
		
		return session.delete(nameSpace+".deleteById",id);
	}

	@Override
	public int deleteByIds(Serializable[] ids) {
		SqlSession session = sessionFactory.openSession(true);
		return session.delete(nameSpace+".deleteByIds", ids);
	}

	@Override
	public int insertOne(T entity) {
		SqlSession session = sessionFactory.openSession(true);
		return session.insert(nameSpace+".insertOne",entity);
	}


	@Override
	public int updateOne(T eneity) {
		SqlSession session = sessionFactory.openSession(true);
		return session.update(nameSpace+".updateOne", eneity);
	}


}
