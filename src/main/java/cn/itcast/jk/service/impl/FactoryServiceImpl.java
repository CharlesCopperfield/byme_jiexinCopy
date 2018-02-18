package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.FactoryService;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月30日 - 上午10:24:03    
 */
@Service
public class FactoryServiceImpl  implements FactoryService {
	
	
	@Autowired
	private FactoryDao factoryDao;
	public void setFactoryDao(FactoryDao factoryDao) {
		this.factoryDao = factoryDao;
	}
	
	

	@Override
	public List<Factory> findAll() {
		return factoryDao.findAll();
	}

	@Override
	public Factory findById(String id) {
		return factoryDao.findById(id);
	}

	@Override
	public int deleteById(String id) {
		return factoryDao.deleteById(id);
	}

	@Override
	public int deleteByIds(Serializable[] ids) {
		if (ids != null && ids.length>0) {
			return factoryDao.deleteByIds(ids);
		}else {
			return -1;
		}
	}

	@Override
	public int insertOne(Factory factory) {
		factory.setId(UUID.randomUUID().toString());//设置ID
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		factory.setCreateTime(new Date());//设置时间
		factory.setState(Factory.STATE_START);//默认为开启状态.
		return factoryDao.insertOne(factory);
	}

	@Override
	public int updateOne(Factory factory) {
		return factoryDao.updateOne(factory);
	}
	
	
	
	@Override
	public int stopStateByIds(String[] ids) {
		if (ids != null && ids.length>0) {
			Map<String, Object> changeStateMap = new HashMap<>();//这样做都是为了性能.
			changeStateMap.put("state", Factory.STATE_STOP);
			changeStateMap.put("ids", ids);
			return factoryDao.changeState(changeStateMap);
		}else {
			return -1;
		}
	}



	@Override
	public int startStateByIds(String[] ids) {
		if (ids != null && ids.length>0) {
			Map<String, Object> changeStateMap = new HashMap<>();//这样做都是为了性能.
			changeStateMap.put("state", Factory.STATE_START);
			changeStateMap.put("ids", ids);
			return factoryDao.changeState(changeStateMap);
		}else {
			return -1;
		}
	}



	@Override
	public List<String> findAllName() {
		return factoryDao.findAllName();
	}
	

}
