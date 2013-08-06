package cn.com.widemex.streetDiscount.shopPlatform.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class ChatRobot {

	public static String chat(String content) throws IOException{
		
		String url="http://sandbox.api.simsimi.com/request.p";
		String strResult = "";  
		DefaultHttpClient httpClient = new DefaultHttpClient();  
		//GET的URL,参数直接加URL后
		 HttpPost post = new HttpPost(url);  
	        List<BasicNameValuePair> postData = new ArrayList<BasicNameValuePair>();   
	         postData.add(new BasicNameValuePair("key", "6240d29d-2cfa-45fc-87e2-ffb5ac3cdc59"));  
	         postData.add(new BasicNameValuePair("text", content)); 
	         postData.add(new BasicNameValuePair("lc", "ch")); 
	         postData.add(new BasicNameValuePair("ft", "1.0")); 
	        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postData,HTTP.UTF_8);//
	        post.setEntity(entity);  
	        HttpResponse response = httpClient.execute(post);    
	        // 若状态码为200 ok  
	        if (response.getStatusLine().getStatusCode() == 200) {  
	            // 取出回应字串  
	            strResult = EntityUtils.toString(response.getEntity());  
	        }  
	        return (String)JsonUtil.parseJsonObject(strResult).get("response");  
		
			
        	
	}
	
	public static String chatImg(String imgUrl) throws IOException, URISyntaxException{
		String url="http://api2.sinaapp.com/recognize/picture/";
		String strResult = "";  
		DefaultHttpClient httpClient = new DefaultHttpClient(); 
		 List<BasicNameValuePair> postData = new ArrayList<BasicNameValuePair>();   
         postData.add(new BasicNameValuePair("appkey", "0020120430"));  
         postData.add(new BasicNameValuePair("appsecert", "fa6095e123cd28fd")); 
         postData.add(new BasicNameValuePair("reqtype", "text")); 
         postData.add(new BasicNameValuePair("keyword", imgUrl)); 
	     // Get请求
		            HttpGet httpget = new HttpGet(url);
		            // 设置参数
		            String str = EntityUtils.toString(new UrlEncodedFormEntity(postData));
		            httpget.setURI(new URI(httpget.getURI().toString() + "?" + str));
		            // 发送请求
		            HttpResponse httpresponse = httpClient.execute(httpget);
		            // 获取返回数据
		            HttpEntity entity = httpresponse.getEntity();
		            strResult = EntityUtils.toString(entity);

	        return (String)((Map)JsonUtil.parseJsonObject(strResult).get("text")).get("content");  
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException{
		System.out.println(chat("你叫什么名字"));
		//System.out.println(chatImg("http://mmsns.qpic.cn/mmsns/7pYjpBua4EWmegW7mjy5UWwLhqia8VyHazibNRTwe6uFicmJGH5k5jbTg/0"));
	}
}
