package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.org.apache.bcel.internal.generic.I2F;

import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.vo.ContractVO;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月30日 - 下午3:05:00    
 */
@Service
public class ContractServiceImpl implements ContractService {
	
	@Autowired	
	private ContractDao contractDao;
	public void setContractDao(ContractDao contractDao) {
		this.contractDao = contractDao;
	}
	
	@Override
	public List<Contract> findAll() {
		return contractDao.findAll();
	}

	public Contract findById(String id) {
		if (id != null) {
			return contractDao.findById(id);
		}
		return null;
	}

	@Override
	public int deleteById(String id) {
		if (id != null) {
			return contractDao.deleteById(id);
		}
		return -1;
	}

	@Override
	public int deleteByIds(Serializable[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertOne(Contract contract) {
		if (contract != null) {
			contract.setId(UUID.randomUUID().toString());//设置合同id
			contract.setTotalAmount(0);//新增合同总金额为0
			contract.setCreateTime(new Date());//设置创建时间
			contract.setState(Contract.STATE_DRAFT);//起始为草稿状态
			contractDao.insertOne(contract);
		}
		return -1;
	}

	@Override
	public int updateOne(Contract contract) {
		if (contract != null) {
			return contractDao.updateOne(contract);
		}
		return -1;
	}

	@Override
	public int reportContractById(String id) {
		if (id != null) {
			Map<String, Object> changeStateMap = new HashMap<>();
			changeStateMap.put("id", id);//
			changeStateMap.put("state", Contract.STATE_REPORTED);//上报状态
			return contractDao.changeState(changeStateMap);
		}
		return -1;
	}

	@Override
	public int cancelContractReportById(String id) {
		if (id != null) {
			Map<String, Object> changeStateMap = new HashMap<>();
			changeStateMap.put("id", id);//
			changeStateMap.put("state", Contract.STATE_DRAFT);//草稿状态
			return contractDao.changeState(changeStateMap);
		}
		return -1;
	}

	@Override
	public int updateTotalAmount(Contract contract) {
		if (contract != null) {
			return contractDao.updateTotalAmount(contract);
		}
		return -1;
	}

	@Override
	public ContractVO view(String contractId) {
		if (contractId != null) {
			return contractDao.view(contractId);
		}
		return null;
	}

}
