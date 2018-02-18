package dao;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.jk.dao.impl.ContractProductDaoImpl;
import cn.itcast.jk.domain.ContractProduct;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 下午3:02:05    
 */
public class ContractProductTest {
	

	SqlSessionFactory sqlSessionFactory;
	ContractProductDaoImpl contractProductDaoImpl = new ContractProductDaoImpl();
	
	@Before
	public void init() {
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
			contractProductDaoImpl.setSqlSessionFactr(sqlSessionFactory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test/**测试findAll.*/
	public void testFindAll() {
		List<ContractProduct> contractProducts = contractProductDaoImpl.findAll();
		System.out.println(contractProducts.size());
	}
	
	@Test/**测试findById*/
	public void testFindById() {
		List<ContractProduct> contractProducts = contractProductDaoImpl.findAll();
		System.out.println(contractProducts.get(0).getId());
		ContractProduct factory = contractProductDaoImpl.findById(contractProducts.get(0).getId());
		System.out.println(factory);
	}
	
	@Test/**测试deleteById*/
	public void testDeleteById() {
		List<ContractProduct> contractProducts = contractProductDaoImpl.findAll();
		int num = contractProductDaoImpl.deleteById(contractProducts.get(1).getId());
		System.out.println(num);
	}
	
	
	@Test/**测试deleteByIds*/
	public void testDeleteByIds() {
		List<ContractProduct> contractProducts = contractProductDaoImpl.findAll();
		String[] ids = {contractProducts.get(0).getId(),contractProducts.get(1).getId(),contractProducts.get(2).getId()};
		int num = contractProductDaoImpl.deleteByIds(ids);
		System.out.println(num);
	}
	
	@Test/**测试insertOne*/
	public void testInsertOne() {
		List<ContractProduct> contractProducts = contractProductDaoImpl.findAll();
		ContractProduct factory = contractProducts.get(0);
		factory.setId(UUID.randomUUID().toString());
		int num = contractProductDaoImpl.insertOne(factory);
		System.out.println(num);
	}
	
	@Test/**测试updateOne*/
	public void testUpdateOne() {
		List<ContractProduct> contractProducts = contractProductDaoImpl.findAll();
		ContractProduct factory = contractProducts.get(0);
		int num = contractProductDaoImpl.updateOne(factory);
		System.out.println(num);
	}

}
