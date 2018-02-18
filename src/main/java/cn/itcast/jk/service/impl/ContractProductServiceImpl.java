package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.ContractProductDao;
import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.ContractService;

/** 
 * 合同业务层接口实现类
 * @author  Charles Copperfield 
 * @date 2018年1月2日 - 上午8:12:46    
 */
@Service
public class ContractProductServiceImpl implements ContractProductService {

	@Autowired
	private ContractProductDao contractProductDao;
	@Autowired
	private FactoryDao factoryDao;
	
	@Override
	public List<ContractProduct> findAll() {
		return contractProductDao.findAll();
	}

	@Override
	public ContractProduct findById(String id) {
		if (id != null) {
			return contractProductDao.findById(id);
		}
		return null;
		
	}

	@Override
	public int deleteById(String id) {
		if (id != null) {
			return contractProductDao.deleteById(id);
		}
		return -1;
	}

	@Override
	public int deleteByIds(Serializable[] ids) {
		if (ids != null) {
			contractProductDao.deleteByIds(ids);
		}
		return -1;
	}

	@Override
	public int insertOne(ContractProduct contractProduct) {
		if (contractProduct != null) {
			contractProduct.setId(UUID.randomUUID().toString());//设置id
			contractProduct.setAmount(contractProduct.getPrice()*contractProduct.getCnumber());//总金额=单价*数量
			return contractProductDao.insertOne(contractProduct);
		}
		return -1;
	}

	@Override
	public int updateOne(ContractProduct contractProduct) {
		if (contractProduct != null) {
			contractProduct.setAmount(contractProduct.getPrice()*contractProduct.getCnumber());//总金额=单价*数量
			return contractProductDao.updateOne(contractProduct);
		}
		return -1;
	}

	@Override
	public List<ContractProduct> findAllByContractId(String contractId) {
		if (contractId != null) {
			return contractProductDao.findAllByContractId(contractId);
		}
		return null;
	}

}
