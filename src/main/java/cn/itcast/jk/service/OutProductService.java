package cn.itcast.jk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.itcast.jk.vo.OutProductVO;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2018年1月3日 - 下午5:05:57    
 */
@Service
public interface OutProductService {

	public List<OutProductVO> findAllBySigningDate(String inputDate);

}
