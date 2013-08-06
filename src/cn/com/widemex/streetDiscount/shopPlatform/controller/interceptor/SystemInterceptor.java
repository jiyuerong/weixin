package cn.com.widemex.streetDiscount.shopPlatform.controller.interceptor;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.com.widemex.framework.logging.WideLogger;
import cn.com.widemex.streetDiscount.shopPlatform.util.AttackDefenceUtil;
import cn.com.widemex.streetDiscount.shopPlatform.util.SensitiveWordCheckUtil;

public class SystemInterceptor extends HandlerInterceptorAdapter {
	
	private static final WideLogger logger = WideLogger.getLogger(SystemInterceptor.class);
	
	@Autowired
	private AttackDefenceUtil attackDefenceUtil;
	
	@Autowired
	private SensitiveWordCheckUtil sensitiveCheckUtil;
	
//	@Override  
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  
//
//		Enumeration<String> params = request.getParameterNames();
//		while(params.hasMoreElements()){
//			String name = params.nextElement();
//			String[] values = request.getParameterValues(name);
//			for(String value : values){
////				if(this.attackDefenceUtil.hasSqlInjectAttackRisk(value)){
////					logger.warn(name + " " + value + " has sql inject attackable word");
////					throw new AppSecurityException();
////				}
//				if(name.startsWith("richText_")){
//					if(this.attackDefenceUtil.hasRichHtmlXss(value)){
//						logger.warn(name + " " + value + " has xss attackable word");
//						throw new AppSecurityException();
//					}
//				}
//				else{
//					if(this.attackDefenceUtil.hasHtmlTags(value)){
//						logger.warn(name + " " + value + " has html tags");
//						throw new AppSecurityException();
//					}
//				}
//				if(this.sensitiveCheckUtil.hasSensitiveWord(value)){
//					logger.warn(name + " " + value + " has sensitive word");
//					throw new SensitiveWordException();
//				}
//			}
//		}
//		
//        return true;  
//    }  
//    @Override  
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {  
//        //System.out.println("===========HandlerInterceptor1 postHandle");  
//    }  
    @Override  
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {  
        //System.out.println("===========HandlerInterceptor1 afterCompletion"); 
    }  

}
