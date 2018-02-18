package dao;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.jk.dao.impl.ExportDaoImpl;
import cn.itcast.jk.domain.Export;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 下午3:35:55    
 */
public class ExportTest {
	

	SqlSessionFactory sqlSessionFactory;
	ExportDaoImpl exportDaoImpl = new ExportDaoImpl();
	
	@Before
	public void init() {
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
			exportDaoImpl.setSqlSessionFactr(sqlSessionFactory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test/**测试findAll.*/
	public void testFindAll() {
		List<Export> exports = exportDaoImpl.findAll();
		System.out.println(exports.size());
	}
	
	@Test/**测试findById*/
	public void testFindById() {
		List<Export> exports = exportDaoImpl.findAll();
		System.out.println(exports.get(0).getId());
		Export factory = exportDaoImpl.findById(exports.get(0).getId());
		System.out.println(factory);
	}
	
	@Test/**测试deleteById*/
	public void testDeleteById() {
		List<Export> exports = exportDaoImpl.findAll();
		int num = exportDaoImpl.deleteById(exports.get(1).getId());
		System.out.println(num);
	}
	
	
	@Test/**测试deleteByIds*/
	public void testDeleteByIds() {
		List<Export> exports = exportDaoImpl.findAll();
		String[] ids = {exports.get(0).getId(),exports.get(1).getId(),exports.get(2).getId()};
		int num = exportDaoImpl.deleteByIds(ids);
		System.out.println(num);
	}
	
	@Test/**测试insertOne*/
	public void testInsertOne() {
		List<Export> exports = exportDaoImpl.findAll();
		Export factory = exports.get(0);
		factory.setId(UUID.randomUUID().toString());
		int num = exportDaoImpl.insertOne(factory);
		System.out.println(num);
	}
	
	@Test/**测试updateOne*/
	public void testUpdateOne() {
		List<Export> exports = exportDaoImpl.findAll();
		Export factory = exports.get(0);
		int num = exportDaoImpl.updateOne(factory);
		System.out.println(num);
	}

}
