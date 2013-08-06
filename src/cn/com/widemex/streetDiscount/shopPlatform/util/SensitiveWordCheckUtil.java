package cn.com.widemex.streetDiscount.shopPlatform.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SensitiveWordCheckUtil {
	
	@Autowired
	private ProjectProperties projectProperties;
	
	/**
	 * 检查是否有敏感词
	 * @param value
	 * @return
	 */
	public boolean hasSensitiveWord(String value){
		String sensitiveStr = this.projectProperties.getSensitiveWord();
		String sensitiveStrs[] = sensitiveStr.split("\\|");	
		for (int i = 0; i < sensitiveStrs.length; i++) {
			if (value.toLowerCase().indexOf(sensitiveStrs[i]) >= 0) {
				return true;
			}
		}
		return false;
	}

}
