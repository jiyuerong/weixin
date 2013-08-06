package cn.com.widemex.streetDiscount.shopPlatform.util;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OpLogPropertiesUtil {

	@Autowired
	@Qualifier("opLogProperties")
	private Properties opLogProperties;
	
	public String getOpLogProperty(String key){
		return (String)this.opLogProperties.get(key);
	}
}
