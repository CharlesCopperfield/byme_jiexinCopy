package cn.itcast.jk.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.OutProductVODao;
import cn.itcast.jk.vo.OutProductVO;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2018年1月3日 - 下午5:09:00    
 */
@Repository
public class OutProductVODaoImpl implements OutProductVODao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private String nameSpace = "cn.itcast.jk.mapper.OutProductVOMapper";

	@Override
	public List<OutProductVO> findAllBySigningDate(String inputDate) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList(nameSpace+".findAllBySigningDate", inputDate);
	}

}













