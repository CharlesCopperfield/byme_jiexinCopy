package cn.itcast.jk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.domain.ContractProduct;

/** 
 * 合同货物dao层接口
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 上午11:47:44    
 */
@Repository
public interface ContractProductDao extends BaseDao<ContractProduct>{

	/**查询指定合同id下的所有货物*/
	List<ContractProduct> findAllByContractId(String contractId);

}
