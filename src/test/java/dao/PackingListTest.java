package dao;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.jk.dao.impl.PackingListDaoImpl;
import cn.itcast.jk.domain.PackingList;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 下午5:31:25    
 */
public class PackingListTest {
	

	SqlSessionFactory sqlSessionFactory;
	PackingListDaoImpl packingListDaoImpl = new PackingListDaoImpl();
	
	@Before
	public void init() {
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
			packingListDaoImpl.setSqlSessionFactr(sqlSessionFactory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test/**测试findAll.*/
	public void testFindAll() {
		List<PackingList> contractProducts = packingListDaoImpl.findAll();
		System.out.println(contractProducts.size());
	}
	
	@Test/**测试findById*/
	public void testFindById() {
		List<PackingList> contractProducts = packingListDaoImpl.findAll();
		System.out.println(contractProducts.get(0).getId());
		PackingList factory = packingListDaoImpl.findById(contractProducts.get(0).getId());
		System.out.println(factory);
	}
	
	@Test/**测试deleteById*/
	public void testDeleteById() {
		List<PackingList> contractProducts = packingListDaoImpl.findAll();
		int num = packingListDaoImpl.deleteById(contractProducts.get(1).getId());
		System.out.println(num);
	}
	
	
	@Test/**测试deleteByIds*/
	public void testDeleteByIds() {
		List<PackingList> contractProducts = packingListDaoImpl.findAll();
		String[] ids = {contractProducts.get(0).getId(),contractProducts.get(1).getId(),contractProducts.get(2).getId()};
		int num = packingListDaoImpl.deleteByIds(ids);
		System.out.println(num);
	}
	
	@Test/**测试insertOne*/
	public void testInsertOne() {
		List<PackingList> contractProducts = packingListDaoImpl.findAll();
		PackingList factory = contractProducts.get(0);
		factory.setId(UUID.randomUUID().toString());
		int num = packingListDaoImpl.insertOne(factory);
		System.out.println(num);
	}
	
	@Test/**测试updateOne*/
	public void testUpdateOne() {
		List<PackingList> contractProducts = packingListDaoImpl.findAll();
		PackingList factory = contractProducts.get(0);
		int num = packingListDaoImpl.updateOne(factory);
		System.out.println(num);
	}

	
	
	
	
	
	
	
	
	
	
	

}
