package dao;
/** 
 * 测试factory的dao层
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 上午8:32:25    
 */

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.jk.dao.impl.FactoryDaoImpl;
import cn.itcast.jk.domain.Factory;

public class FactoryTest {
	
	SqlSessionFactory sqlSessionFactory;
	FactoryDaoImpl factoryDaoImpl = new FactoryDaoImpl();
	
	@Before
	public void init() {
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
			factoryDaoImpl.setSqlSessionFactr(sqlSessionFactory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test/**测试findAll.*/
	public void testFindAll() {
		List<Factory> factories = factoryDaoImpl.findAll();
		System.out.println(factories.size());
	}
	
	@Test/**测试findById*/
	public void testFindById() {
		List<Factory> factories = factoryDaoImpl.findAll();
		System.out.println(factories.get(0).getId());
		Factory factory = factoryDaoImpl.findById("1");
		System.out.println(factory);
	}
	
	@Test/**测试deleteById*/
	public void testDeleteById() {
		List<Factory> factories = factoryDaoImpl.findAll();
		int num = factoryDaoImpl.deleteById(factories.get(1).getId());
		System.out.println(num);
	}
	
	
	@Test/**测试deleteByIds*/
	public void testDeleteByIds() {
		List<Factory> factories = factoryDaoImpl.findAll();
		String[] ids = {factories.get(0).getId(),factories.get(1).getId(),factories.get(2).getId()};
		int num = factoryDaoImpl.deleteByIds(ids);
		System.out.println(num);
	}
	
	@Test/**测试insertOne*/
	public void testInsertOne() {
		List<Factory> factories = factoryDaoImpl.findAll();
		Factory factory = factories.get(0);
		factory.setId(UUID.randomUUID().toString());
		int num = factoryDaoImpl.insertOne(factory);
		System.out.println(num);
	}
	
	@Test/**测试updateOne*/
	public void testUpdateOne() {
		List<Factory> factories = factoryDaoImpl.findAll();
		Factory factory = factories.get(0);
		factory.setMobile("111111");
		int num = factoryDaoImpl.updateOne(factory);
		System.out.println(num);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
