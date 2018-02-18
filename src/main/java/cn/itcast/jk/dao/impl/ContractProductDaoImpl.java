package cn.itcast.jk.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.ContractProductDao;
import cn.itcast.jk.domain.ContractProduct;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 上午11:49:12    
 */
@Repository
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private static String nameSpace="cn.itcast.jk.mapper.ContractProductMapper";
	public ContractProductDaoImpl() {
		super(nameSpace);
	}
	
	
	@Override
	public List<ContractProduct> findAllByContractId(String contractId) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList(nameSpace+".findAllByContractId", contractId);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
