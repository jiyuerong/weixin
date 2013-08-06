package cn.com.widemex.streetDiscount.shopPlatform.util;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.widemex.framework.logging.WideLogger;

@Component
public class AttackDefenceUtil {

	private static final WideLogger logger = WideLogger.getLogger(AttackDefenceUtil.class);
	
	@Autowired
	private ProjectProperties projectProperties;
	
	/**
	 * 检查是否含有sql注入非法字符串
	 * @param value
	 * @return
	 */
	public boolean hasSqlInjectAttackRisk(String value) {
		
		if(StringUtils.isBlank(value)){
			return false;
		}
		
		//sql注入防范
		return(!StringEscapeUtils.escapeSql(value).equals(value));
//		String injStr = this.projectProperties.getSqlInject();
//		String injStrs[] = injStr.split("\\|");
//		for (int i = 0; i < injStrs.length; i++) {
//			if (value.toLowerCase().indexOf(injStrs[i]) >= 0) {
//				return true;
//			}
//		}

	}
	
	/**
	 * 检测是否为普通文本，不含html标签
	 * @param value
	 * @return
	 */
	public boolean hasHtmlTags(String value){
		
		return (!Jsoup.isValid(value, Whitelist.none()));
	}
	
	/**
	 * 富文本XSS检测
	 * @param value
	 * @return
	 */
	public boolean hasRichHtmlXss(String value){
		
		return (!Jsoup.isValid(value, Whitelist.relaxed()));
		
	}
	

}
