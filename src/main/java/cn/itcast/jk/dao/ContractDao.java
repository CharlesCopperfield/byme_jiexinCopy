package cn.itcast.jk.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.vo.ContractVO;

/** 
 * 合同dao层
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 上午11:44:28    
 */
@Repository
public interface ContractDao extends BaseDao<Contract> {

	/**更改上报状态*/
	int changeState(Map<String, Object> changeStateMap);

	/**更新合同总金额字段*/
	int updateTotalAmount(Contract contract);

	/**获取指定合同的contractVO*/
	ContractVO view(String contractId);

}
