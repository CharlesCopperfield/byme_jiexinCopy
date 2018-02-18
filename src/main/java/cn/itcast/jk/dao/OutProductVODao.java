package cn.itcast.jk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.vo.OutProductVO;

/** 
 * 打印月份出货表vo之dao
 * @author  Charles Copperfield 
 * @date 2018年1月3日 - 下午5:01:47    
 */
@Repository
public interface OutProductVODao {

	/**查询指定月份的打印合同清单*/
	List<OutProductVO> findAllBySigningDate(String inputDate);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
