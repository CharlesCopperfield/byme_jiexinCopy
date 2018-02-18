package cn.itcast.jk.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.domain.Factory;

/** 
 * 封装factory数据库的交互行为.
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 上午8:02:45    
 */
@Repository
public class FactoryDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Override
	public void setSqlSessionFactr(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactr(sqlSessionFactory);
	}
	private static String nameSpace="cn.itcast.jk.mapper.FactoryMapper";
	public FactoryDaoImpl() {
		super(nameSpace);
	}
	
	@Override
	public int changeState(Map<String,Object> changeStateMap) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.update(nameSpace+".changeState", changeStateMap);
	}

	@Override
	public List<String> findAllName() {
		SqlSession session = sqlSessionFactory.openSession();
		
		return session.selectList(nameSpace+".findAllName");
	}

	

}










