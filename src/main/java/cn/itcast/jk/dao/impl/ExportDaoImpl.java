package cn.itcast.jk.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.jk.dao.ExportDao;
import cn.itcast.jk.domain.Export;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 上午11:51:59    
 */
public class ExportDaoImpl extends BaseDaoImpl<Export> implements ExportDao {

	private SqlSessionFactory sqlSessionFactory;
	public ExportDaoImpl() {
		super("cn.itcast.jk.mapper.ExportMapper");
	}

}
