package cn.com.widemex.streetDiscount.shopPlatform.test;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Test {
	

	
	public static void urlReader(URL url){  
        //获取协议名  
        String protocol = url.getProtocol();  
        //获取主机名  
        String host = url.getHost();  
        //获取端口号  
        int port = url.getPort();  
        //获取文件名  
        String file = url.getFile();  
        //获取锚点（引用）  
        String ref = url.getRef();  
        //获取查询信息  
        String query = url.getQuery();  
        //获取路径  
        String path = url.getPath();  
        //获取权限信息  
        String authority = url.getAuthority();  
        //获取使用者的信息  
        String userinfo = url.getUserInfo();  
        System.out.println("协议名："+protocol);  
        System.out.println("主机名："+ host);  
        System.out.println("端口号："+port);  
        System.out.println("文件名："+file);  
        System.out.println("锚点："+ref);  
        System.out.println("查询信息："+query);  
        System.out.println("路径："+path);  
        System.out.println("权限信息："+authority);  
        System.out.println("使用者信息："+userinfo);  
    }  
	
	
	public static void main(String[] args) throws IOException{
		Document doc = Jsoup.connect("http://news.ifeng.com/exclusive/official/special/clist_0/1.shtml").get(); 
		Iterator<Element> iterator = doc.getElementsByClass("box02_1").iterator();
		while(iterator.hasNext()){
			Element ele = iterator.next();
			System.out.println(ele.getElementsByTag("h3").first().text());
			System.out.println(ele.getElementsByTag("img").first().attr("src"));		
			System.out.println(ele.getElementsByTag("p").first().textNodes().get(0).text());
			System.out.println(ele.getElementsByTag("h3").first().getElementsByTag("a").attr("href"));
			System.out.println();
		}
		
		
	}
	
	
	

}
