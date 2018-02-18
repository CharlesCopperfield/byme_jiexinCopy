package cn.itcast.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/** 
 * 全站乱码过滤器.
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 下午8:16:01    
 */
public class EncodingFilter implements Filter {
	/**全站统一所用编码,默认是utf-8*/
	private String encoding="utf-8";
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println(encoding);
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		
		//运用装饰者模式,解决请求参数的编解码问题.
		request = new EncodingHttpServletRequest((HttpServletRequest)request,encoding);
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//这句很重要,如果配置文件中配置了encoding,则改掉默认编码
		if (filterConfig.getInitParameter("encoding")!=null) {
			encoding=filterConfig.getInitParameter("encoding");
		}
	}
	
	@Override
	public void destroy() {
	}
	
	/**内部类,解决全站编解码问题的实际处理类.*/
	static class EncodingHttpServletRequest extends HttpServletRequestWrapper {
		
		private HttpServletRequest request;
		private String encoding;
		public EncodingHttpServletRequest(HttpServletRequest request,String encoding) {
			super(request);
			this.request = request;
			this.encoding = encoding;
		}
		
		@Override
		 public Map<String, String[]> getParameterMap(){
			 //只需要对get方法进行处理
			 if (request.getMethod().equalsIgnoreCase("GET")) {
				 Map<String, String[]> oldParameterMap = request.getParameterMap();
				 Set<String> oldKeySet = oldParameterMap.keySet();
				 Map<String, String[]> newParameterMap = new HashMap<>();
				 for (String oldKey : oldKeySet) {//先处理String
						try {
							String newKey = new String(oldKey.getBytes("iso8859-1"),encoding);
							
							String[] oldValueSet = oldParameterMap.get(oldKey);
							String[] newValueSet = new String[oldValueSet.length];
							for (int i=0; i<oldValueSet.length; i++) {//处理此String下的String[]
								String newValue = new String(oldValueSet[i].getBytes("iso8859-1"),encoding);
								newValueSet[i] = newValue;
							}
							//将解码后的值放入要返回的map集合中
							newParameterMap.put(newKey, newValueSet);
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
							throw new RuntimeException("EncodingFilter发生未知异常!");
						}
				}
				 return newParameterMap;
			}
			 /**如果不是get方法,则不用进行编解码处理.*/
			 return request.getParameterMap();
		 }
		 
		 @Override
		 public String getParameter(String name) {
			 String[] parameterMap = getParameterMap().get(name);
			 if (parameterMap!=null && parameterMap.length>0) {
				 return getParameterMap().get(name)[0];
			 }else {
				return null;
			}
			 
		 }
		 
		 @Override
		 public String[] getParameterValues(String name) {
			 return getParameterMap().get(name);
		 }
		 
		 @Override
		 public Enumeration<String> getParameterNames(){
			 Map<String, String[]> parameterMap = getParameterMap();
			 if (parameterMap == null) {
				return null;
			}
			 Set<String> nameSet = parameterMap.keySet();
			 return  Collections.enumeration(nameSet);
		 }
		 
		
	}

}

















