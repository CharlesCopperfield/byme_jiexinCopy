package cn.itcast.jk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.itcast.jk.domain.ContractProduct;

/** 
 * 合同货物业务层接口
 * @author  Charles Copperfield 
 * @date 2018年1月2日 - 上午8:11:19    
 */
@Service
public interface ContractProductService extends BaseService<ContractProduct> {

	/**查询指定合同id下的所有货物*/
	List<ContractProduct> findAllByContractId(String contractId);

	
	
	
	
	
}
