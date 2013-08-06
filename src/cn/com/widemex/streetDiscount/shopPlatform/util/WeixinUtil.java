package cn.com.widemex.streetDiscount.shopPlatform.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class WeixinUtil {

	public static List<Map<String, Object>> getLocationCoupon(String lat, String lon, String label) throws ClientProtocolException, IOException{
		
		String url="http://www.widemex.com.cn:9080/WebServer/nearby.msp";
		String strResult = "";  
		DefaultHttpClient httpClient = new DefaultHttpClient();  
		//GET的URL,参数直接加URL后
		 HttpPost post = new HttpPost(url);  
	        List<BasicNameValuePair> postData = new ArrayList<BasicNameValuePair>();   
	         postData.add(new BasicNameValuePair("lon", lon));  
	         postData.add(new BasicNameValuePair("lat", lat)); 
	         postData.add(new BasicNameValuePair("desc", label));  
	         postData.add(new BasicNameValuePair("typecode", "0")); 
	         postData.add(new BasicNameValuePair("sourceid", "7")); 
	         postData.add(new BasicNameValuePair("userid", "2013051748835")); 
	         postData.add(new BasicNameValuePair("dpi", "480-800")); 
	         postData.add(new BasicNameValuePair("cityid", "552")); 
	         postData.add(new BasicNameValuePair("begin", "1")); 
	         postData.add(new BasicNameValuePair("number", "10")); 
	        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postData,HTTP.UTF_8);//
	        post.setEntity(entity);  
	        HttpResponse response = httpClient.execute(post);    
	        // 若状态码为200 ok  
	        if (response.getStatusLine().getStatusCode() == 200) {  
	            // 取出回应字串  
	            strResult = EntityUtils.toString(response.getEntity());  
	        }  
	        //System.out.println(strResult);
	        strResult = strResult.replaceAll("\\\\", "");
	        Map<String, Object> results = JsonUtil.parseJsonObject(strResult);
	        String result = (String)results.get("result");
	        if(!"1".equals(result)){
	        	return null;
	        }
	        else{
	        	return (List<Map<String, Object>>)results.get("list");
	        }
		
	}
	
	
	public static void main(String[] args) throws ClientProtocolException, IOException{
		List<Map<String, Object>> ret = WeixinUtil.getLocationCoupon("31.8408", "117.144819", "安徽省合肥市肥西县科二路");
		System.out.println(ret.size());
	}
	
	public static <T> String object2XML(T o) throws JAXBException, UnsupportedEncodingException{

		JAXBContext context = JAXBContext.newInstance(o.getClass());  
        
        Marshaller marshaller = context.createMarshaller();  
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        marshaller.marshal(o, out);  
        return new String(out.toByteArray(), "UTF-8");  
	}
}
