package cn.com.widemex.streetDiscount.shopPlatform.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import cn.com.widemex.framework.logging.WideLogger;
import cn.com.widemex.streetDiscount.shopPlatform.exception.AppException;



public class JsonUtil {
	
	private static final  ObjectMapper MAPPER = new ObjectMapper();
	
	private static final WideLogger logger = WideLogger.getLogger(JsonUtil.class);

	public static List<Map<String, Object>> parseJsonArray(String jsonArrayStr) {
		
		try {
			return MAPPER.readValue(jsonArrayStr,
					new TypeReference<List<Map<String, Object>>>(){
			});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			logger.error(jsonArrayStr, e);
			throw new AppException(e.toString());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			logger.error(jsonArrayStr, e);
			throw new AppException(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(jsonArrayStr, e);
			throw new AppException(e.toString());
		}
		
		
	}
	
     public static Map<String, Object> parseJsonObject(String jsonObjectStr) {
		
		try {
			return MAPPER.readValue(jsonObjectStr,
					new TypeReference<Map<String, Object>>(){
			});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			logger.error(jsonObjectStr, e);
			throw new AppException(e.toString());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			logger.error(jsonObjectStr, e);
			throw new AppException(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(jsonObjectStr, e);
			throw new AppException(e.toString());
		}
		
		
	}
	
	
	public static String getJsonStr(List<Map<Object, Object>> maps){	
		
		StringWriter writer = new StringWriter();
		try {
			MAPPER.writeValue(writer, maps);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			logger.error("", e);
			throw new AppException(e.toString());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			logger.error("", e);
			throw new AppException(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("", e);
			throw new AppException(e.toString());
		}
		return writer.toString();
	}
	
	public static void main(String[] args){
		List<Map<String, Object>> list = parseJsonArray("[{\"Key1\": \"1\", \"key2\": \"2\"}]");
		for(Map<String, Object> map : list){
			System.out.println(map.get("Key1"));
		}
		
		List<Map<Object, Object>> content = new ArrayList<Map<Object, Object>>();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("key", "key");
		content.add(map);
		System.out.println(getJsonStr(content));
	}
	
}
