package cn.itcast.jk.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.ExtCproductDao;
import cn.itcast.jk.domain.ExtCproduct;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 上午11:56:44    
 */
@Repository
public class ExtCproductDaoImpl extends BaseDaoImpl<ExtCproduct> implements ExtCproductDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private static String nameSpace = "cn.itcast.jk.mapper.ExtCproductMapper";
	public ExtCproductDaoImpl() {
		super(nameSpace);
	}
	
	@Override
	public List<ExtCproduct> findAllByContractProductId(String contractProductId) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList(nameSpace+".findAllByContractProductId",contractProductId);
	}

}
