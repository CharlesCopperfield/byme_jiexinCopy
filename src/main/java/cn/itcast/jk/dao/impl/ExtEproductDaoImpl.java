package cn.itcast.jk.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.jk.dao.ExtEproductDao;
import cn.itcast.jk.domain.ExtEproduct;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 下午12:00:00    
 */
public class ExtEproductDaoImpl extends BaseDaoImpl<ExtEproduct> implements ExtEproductDao {

	private SqlSessionFactory sqlSessionFactory;
	public ExtEproductDaoImpl() {
		super("cn.itcast.jk.mapper.ExtEproduct");
	}

}
