package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.ExtCproductDao;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.service.ExtCproductService;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2018年1月2日 - 下午8:07:25    
 */
@Service
public class ExtCproductServiceImpl implements ExtCproductService {
	
	@Autowired
	private ExtCproductDao extCproductDao;
	
	@Override
	public List<ExtCproduct> findAll() {
		return null;
	}

	@Override
	public ExtCproduct findById(String id) {
		if (id != null) {
			return extCproductDao.findById(id);
		}
		return null;
	}

	@Override
	public int deleteById(String id) {
		if (id != null) {
			return extCproductDao.deleteById(id);
		}
		return -1;
	}

	@Override
	public int deleteByIds(Serializable[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertOne(ExtCproduct extCproduct) {
		if (extCproduct != null) {
			extCproduct.setId(UUID.randomUUID().toString());//设置ID
			extCproduct.setAmount(extCproduct.getPrice()*extCproduct.getCnumber());//总金额=单价*数量
			return extCproductDao.insertOne(extCproduct);
		}
		return -1;
	}

	@Override
	public int updateOne(ExtCproduct extCproduct) {
		if (extCproduct != null) {
			extCproduct.setAmount(extCproduct.getPrice()*extCproduct.getCnumber());
			extCproductDao.updateOne(extCproduct);
		}
		return -1;
	}

	@Override
	public List<ExtCproduct> findAllByContractProductId(String contractProductId) {
		if (contractProductId != null) {
			return extCproductDao.findAllByContractProductId(contractProductId);
		}
		return null;
	}

}
