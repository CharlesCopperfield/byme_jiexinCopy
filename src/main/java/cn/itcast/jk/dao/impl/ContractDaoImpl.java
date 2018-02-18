package cn.itcast.jk.dao.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.vo.ContractVO;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 上午11:45:53    
 */
@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	private static String nameSpace="cn.itcast.jk.mapper.ContractMapper";
	
	public ContractDaoImpl() {
		super(nameSpace);
	}

	@Override
	public int changeState(Map<String, Object> changeStateMap) {
		SqlSession session = sqlSessionFactory.openSession();
		
		return session.update(nameSpace+".changeState",changeStateMap);
	}

	@Override
	public int updateTotalAmount(Contract contract) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.update(nameSpace+".updateTotalAmount",contract);
	}

	@Override
	public ContractVO view(String contractId) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne(nameSpace+".view",contractId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
