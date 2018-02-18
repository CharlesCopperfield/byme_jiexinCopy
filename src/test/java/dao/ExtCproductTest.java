package dao;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.jk.dao.impl.ExtCproductDaoImpl;
import cn.itcast.jk.domain.ExtCproduct;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 下午4:55:58    
 */
public class ExtCproductTest {
	
	
	SqlSessionFactory sqlSessionFactory;
	ExtCproductDaoImpl extCproductDaoImpl = new ExtCproductDaoImpl();
	
	@Before
	public void init() {
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
			extCproductDaoImpl.setSqlSessionFactr(sqlSessionFactory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test/**测试findAll.*/
	public void testFindAll() {
		List<ExtCproduct> contractProducts = extCproductDaoImpl.findAll();
		System.out.println(contractProducts.size());
	}
	
	@Test/**测试findById*/
	public void testFindById() {
		List<ExtCproduct> contractProducts = extCproductDaoImpl.findAll();
		System.out.println(contractProducts.get(0).getId());
		ExtCproduct factory = extCproductDaoImpl.findById(contractProducts.get(0).getId());
		System.out.println(factory);
	}
	
	@Test/**测试deleteById*/
	public void testDeleteById() {
		List<ExtCproduct> contractProducts = extCproductDaoImpl.findAll();
		int num = extCproductDaoImpl.deleteById(contractProducts.get(1).getId());
		System.out.println(num);
	}
	
	
	@Test/**测试deleteByIds*/
	public void testDeleteByIds() {
		List<ExtCproduct> contractProducts = extCproductDaoImpl.findAll();
		String[] ids = {contractProducts.get(0).getId(),contractProducts.get(1).getId(),contractProducts.get(2).getId()};
		int num = extCproductDaoImpl.deleteByIds(ids);
		System.out.println(num);
	}
	
	@Test/**测试insertOne*/
	public void testInsertOne() {
		List<ExtCproduct> contractProducts = extCproductDaoImpl.findAll();
		ExtCproduct factory = contractProducts.get(0);
		factory.setId(UUID.randomUUID().toString());
		int num = extCproductDaoImpl.insertOne(factory);
		System.out.println(num);
	}
	
	@Test/**测试updateOne*/
	public void testUpdateOne() {
		List<ExtCproduct> contractProducts = extCproductDaoImpl.findAll();
		ExtCproduct factory = contractProducts.get(0);
		int num = extCproductDaoImpl.updateOne(factory);
		System.out.println(num);
	}

}
