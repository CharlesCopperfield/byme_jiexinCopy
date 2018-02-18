package dao;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.jk.dao.impl.ExportProductDaoImpl;
import cn.itcast.jk.domain.ExportProduct;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 下午4:11:28    
 */
public class ExportProductTest {

	SqlSessionFactory sqlSessionFactory;
	ExportProductDaoImpl exportProductDaoImpl = new ExportProductDaoImpl();
	
	@Before
	public void init() {
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
			exportProductDaoImpl.setSqlSessionFactr(sqlSessionFactory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test/**测试findAll.*/
	public void testFindAll() {
		List<ExportProduct> contractProducts = exportProductDaoImpl.findAll();
		System.out.println(contractProducts.size());
	}
	
	@Test/**测试findById*/
	public void testFindById() {
		List<ExportProduct> contractProducts = exportProductDaoImpl.findAll();
		System.out.println(contractProducts.get(0).getId());
		ExportProduct factory = exportProductDaoImpl.findById(contractProducts.get(0).getId());
		System.out.println(factory);
	}
	
	@Test/**测试deleteById*/
	public void testDeleteById() {
		List<ExportProduct> contractProducts = exportProductDaoImpl.findAll();
		int num = exportProductDaoImpl.deleteById(contractProducts.get(1).getId());
		System.out.println(num);
	}
	
	
	@Test/**测试deleteByIds*/
	public void testDeleteByIds() {
		List<ExportProduct> contractProducts = exportProductDaoImpl.findAll();
		String[] ids = {contractProducts.get(0).getId(),contractProducts.get(1).getId(),contractProducts.get(2).getId()};
		int num = exportProductDaoImpl.deleteByIds(ids);
		System.out.println(num);
	}
	
	@Test/**测试insertOne*/
	public void testInsertOne() {
		List<ExportProduct> contractProducts = exportProductDaoImpl.findAll();
		ExportProduct factory = contractProducts.get(0);
		factory.setId(UUID.randomUUID().toString());
		int num = exportProductDaoImpl.insertOne(factory);
		System.out.println(num);
	}
	
	@Test/**测试updateOne*/
	public void testUpdateOne() {
		List<ExportProduct> contractProducts = exportProductDaoImpl.findAll();
		ExportProduct factory = contractProducts.get(0);
		factory.setBoxNum(111111);
		int num = exportProductDaoImpl.updateOne(factory);
		System.out.println(num);
	}
	
	
}












