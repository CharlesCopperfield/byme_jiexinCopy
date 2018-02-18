package dao;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.jk.dao.impl.ContractDaoImpl;
import cn.itcast.jk.domain.Contract;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 下午2:02:44    
 */
public class ContractTest {

	SqlSessionFactory sqlSessionContract;
	ContractDaoImpl contractDaoImpl = new ContractDaoImpl();
	
	@Before
	public void init() {
		try {
			sqlSessionContract = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
			contractDaoImpl.setSqlSessionFactr(sqlSessionContract);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test/**测试findAll.*/
	public void testFindAll() {
		List<Contract> contracts = contractDaoImpl.findAll();
		System.out.println(contracts.size());
	}
	
	@Test/**测试findById*/
	public void testFindById() {
		List<Contract> contracts = contractDaoImpl.findAll();
		System.out.println(contracts.get(0).getId());
		Contract factory = contractDaoImpl.findById(contracts.get(0).getId());
		System.out.println(factory);
	}
	
	@Test/**测试deleteById*/
	public void testDeleteById() {
		List<Contract> contracts = contractDaoImpl.findAll();
		int num = contractDaoImpl.deleteById(contracts.get(1).getId());
		System.out.println(num);
	}
	
	
	@Test/**测试deleteByIds*/
	public void testDeleteByIds() {
		List<Contract> contracts = contractDaoImpl.findAll();
		String[] ids = {contracts.get(0).getId(),contracts.get(1).getId(),contracts.get(2).getId()};
		int num = contractDaoImpl.deleteByIds(ids);
		System.out.println(num);
	}
	
	@Test/**测试insertOne*/
	public void testInsertOne() {
		List<Contract> contracts = contractDaoImpl.findAll();
		Contract factory = contracts.get(0);
		factory.setId(UUID.randomUUID().toString());
		int num = contractDaoImpl.insertOne(factory);
		System.out.println(num);
	}
	
	@Test/**测试updateOne*/
	public void testUpdateOne() {
		List<Contract> contracts = contractDaoImpl.findAll();
		Contract factory = contracts.get(0);
		int num = contractDaoImpl.updateOne(factory);
		System.out.println(num);
	}
	
}
