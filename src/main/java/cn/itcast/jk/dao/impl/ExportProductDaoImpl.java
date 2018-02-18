package cn.itcast.jk.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.jk.dao.ExportProductDao;
import cn.itcast.jk.domain.ExportProduct;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 上午11:54:37    
 */
public class ExportProductDaoImpl extends BaseDaoImpl<ExportProduct> implements ExportProductDao {

	private SqlSessionFactory sqlSessionFactory;
	public ExportProductDaoImpl() {
		super("cn.itcast.jk.mapper.ExportProductMapper");
	}

}
