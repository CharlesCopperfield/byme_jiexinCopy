package cn.itcast.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/** 
 * 基础控制器,抽取出子类控制器都需要的行为.
 * @author  Charles Copperfield 
 * @date 2017年12月30日 - 下午3:44:47    
 */
@Controller
public class BaseController {
	
	/**任何controller执行前都会执行本方法.本方法是在spring中指定date类创建时的格式*/
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    dateFormat.setLenient(true);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
	}  
	
	
	
	
	

}
