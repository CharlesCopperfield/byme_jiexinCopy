package cn.itcast.jk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.OutProductVODao;
import cn.itcast.jk.service.OutProductService;
import cn.itcast.jk.vo.OutProductVO;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2018年1月3日 - 下午5:06:35    
 */
@Service
public class OutProductServiceImpl implements OutProductService {
	
	@Autowired
	private OutProductVODao outProductVODao;

	@Override
	public List<OutProductVO> findAllBySigningDate(String inputDate) {
		if (inputDate != null) {
			return outProductVODao.findAllBySigningDate(inputDate);
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
