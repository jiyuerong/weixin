package cn.com.widemex.streetDiscount.shopPlatform.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GeneralPropertiesUtil {

	@Autowired
	private ProjectProperties projectProperties;
	
	private static ProjectProperties projectPropertiesUtil;
	
	@PostConstruct
	public void init(){
		projectPropertiesUtil = projectProperties;
	}
	
	public static ProjectProperties getProjectProperties(){
		
		return projectPropertiesUtil;
	}
}
