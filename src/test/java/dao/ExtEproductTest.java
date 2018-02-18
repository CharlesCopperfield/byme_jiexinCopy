package dao;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.jk.dao.impl.ExtEproductDaoImpl;
import cn.itcast.jk.domain.ExtEproduct;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 下午5:09:55    
 */
public class ExtEproductTest {
	SqlSessionFactory sqlSessionFactory;
	ExtEproductDaoImpl extEproduct = new ExtEproductDaoImpl();
	
	@Before
	public void init() {
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
			extEproduct.setSqlSessionFactr(sqlSessionFactory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test/**测试findAll.*/
	public void testFindAll() {
		List<ExtEproduct> contractProducts = extEproduct.findAll();
		System.out.println(contractProducts.size());
	}
	
	@Test/**测试findById*/
	public void testFindById() {
		List<ExtEproduct> contractProducts = extEproduct.findAll();
		System.out.println(contractProducts.get(0).getId());
		ExtEproduct factory = extEproduct.findById(contractProducts.get(0).getId());
		System.out.println(factory);
	}
	
	@Test/**测试deleteById*/
	public void testDeleteById() {
		List<ExtEproduct> contractProducts = extEproduct.findAll();
		int num = extEproduct.deleteById(contractProducts.get(1).getId());
		System.out.println(num);
	}
	
	
	@Test/**测试deleteByIds*/
	public void testDeleteByIds() {
		List<ExtEproduct> contractProducts = extEproduct.findAll();
		String[] ids = {contractProducts.get(0).getId(),contractProducts.get(1).getId(),contractProducts.get(2).getId()};
		int num = extEproduct.deleteByIds(ids);
		System.out.println(num);
	}
	
	@Test/**测试insertOne*/
	public void testInsertOne() {
		List<ExtEproduct> contractProducts = extEproduct.findAll();
		ExtEproduct factory = contractProducts.get(0);
		factory.setId(UUID.randomUUID().toString());
		int num = extEproduct.insertOne(factory);
		System.out.println(num);
	}
	
	@Test/**测试updateOne*/
	public void testUpdateOne() {
		List<ExtEproduct> contractProducts = extEproduct.findAll();
		ExtEproduct factory = contractProducts.get(0);
		int num = extEproduct.updateOne(factory);
		System.out.println(num);
	}
}
