package cn.com.widemex.streetDiscount.shopPlatform.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

	@Autowired
	@Qualifier("messageSource")
	private MessageSource messageSource;
	
	private Locale locale = Locale.CHINESE;
	
	public String getMessage(String key, Object[] params, Locale locale){
		
		return messageSource.getMessage(key, params, locale);
		
	}
	
	public String getMessage(String key, Object[] params){
		return this.getMessage(key, params, this.locale);
	}
}
