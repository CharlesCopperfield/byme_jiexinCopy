package cn.itcast.jk.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.jk.dao.PackingListDao;
import cn.itcast.jk.domain.PackingList;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 下午12:51:59    
 */
public class PackingListDaoImpl extends BaseDaoImpl<PackingList> implements PackingListDao {

	
	private SqlSessionFactory sqlSessionFactory;
	public PackingListDaoImpl() {
		super("cn.itcast.jk.mapper.PackingListMapper");
	}

}
