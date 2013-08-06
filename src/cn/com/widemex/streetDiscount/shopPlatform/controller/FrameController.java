package cn.com.widemex.streetDiscount.shopPlatform.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.widemex.framework.logging.WideLogger;
import cn.com.widemex.streetDiscount.shopPlatform.util.ChatRobot;
import cn.com.widemex.streetDiscount.shopPlatform.util.MessageUtil;
import cn.com.widemex.streetDiscount.shopPlatform.util.SecretUtil;
import cn.com.widemex.streetDiscount.shopPlatform.util.WeixinUtil;
import cn.com.widemex.streetDiscount.shopPlatform.vo.Article;
import cn.com.widemex.streetDiscount.shopPlatform.vo.WeixinMessageReqVo;
import cn.com.widemex.streetDiscount.shopPlatform.vo.WeixinMessageRespVo;

@Controller
@RequestMapping(value="/")
public class FrameController extends BaseController {
	
	private static final WideLogger logger = WideLogger.getLogger(FrameController.class);
	
	@Autowired
	private MessageUtil messageUtil;
	
	@ResponseBody
	@RequestMapping(value="weixininterface.do",method=RequestMethod.GET)
	public String signin(HttpServletRequest request) throws NoSuchAlgorithmException{		
		
		if(this.validateRequest(request)){
			String echostr = request.getParameter("echostr");
			return echostr;
		}
		else{
			return null;
		}
		
	}
	
	private boolean validateRequest(HttpServletRequest request) throws NoSuchAlgorithmException{
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String token = "ijiehui";
		
		String[] validations = new String[]{token, timestamp, nonce};
		Arrays.sort(validations);
		String validateStr = SecretUtil.sha1(StringUtils.join(validations, ""));
		logger.info(validateStr);
		if(validateStr.equalsIgnoreCase(signature)){
			return true;
		}
		return false;
	}
	
	@ResponseBody
	@RequestMapping(value="weixininterface.do",method=RequestMethod.POST)
	public WeixinMessageRespVo message(HttpServletRequest request, @RequestBody WeixinMessageReqVo reqXml) throws NoSuchAlgorithmException, IOException, URISyntaxException, JAXBException{		
		
		if(!this.validateRequest(request)){
			return null;
		}
		
		WeixinMessageRespVo resp = new WeixinMessageRespVo();
		resp.setCreateTime(String.valueOf(new Date().getTime() / 1000));
		resp.setFromUserName(reqXml.getToUserName());
		resp.setFuncFlag("1");			
		resp.setToUserName(reqXml.getFromUserName());	
		
		logger.info(ReflectionToStringBuilder.toString(reqXml));
		
		
        logger.info(WeixinUtil.<WeixinMessageReqVo>object2XML(reqXml));  
        
		
		if("text".equalsIgnoreCase(reqXml.getMsgType())){
			
			String content = reqXml.getContent();
			
			if("单条图文".equalsIgnoreCase(content)){
				resp.setMsgType("news");
				resp.setArticleCount("1");
				List<Article> articles = new ArrayList<Article>();
				Article article = new Article();
				article.setTitle("有街惠，不团购");
				article.setPicUrl("http://www.ijiehui.com/images/33.jpg");
				article.setDescription("有街惠，不团购。今日限时特惠就在身边；无需预约，立即享受；到店付钱，省钱又保质");
				article.setUrl("http://www.ijiehui.com");
				articles.add(article);
				resp.setArticles(articles);
			}
			else if("多条图文".equalsIgnoreCase(content)){
				resp.setMsgType("news");
				List<Article> articles = new ArrayList<Article>();
//				String[] titles = new String[]{"有街惠，不团购","武汉公交司机劝阻乘客吃臭豆腐被泼一身"
//						,"官员儿子15岁起有编制领工资：69名员工10人未满18岁"};
//				String[] picUrls = new String[]{"http://www.ijiehui.com/images/33.jpg","http://ww4.sinaimg.cn/bmiddle/644471aejw1e561x785kej20f70agmyd.jpg",
//						"http://ww2.sinaimg.cn/bmiddle/6a5ce645jw1e560whvb7ij20c80f0gni.jpg"};
//				String[] desps = new String[]{"有街惠，不团购。今日限时特惠就在身边；无需预约，立即享受；到店付钱，省钱又保质","武汉公交司机刘师傅正在开车，一中年男子端一碗臭豆腐上车，臭味浓重。刘师傅说公交车有“禁食”规定，请吃完再上车。男子叫道：“哪个规定的？”说完，将臭豆腐泼了刘师傅一身。",
//						"河南叶县水利局下属河道管理所所长赵书奇的儿子，15岁起就捧起了“铁饭碗”，每月1000多元，已经领了6年。记者调查发现，该单位69人员工中，未满18岁有编制的职工竟有10人，大多是所长亲戚！目前，所长已被停职调查。"};
//				String[] urls = new String[]{"http://www.ijiehui.com", "http://news.ctdsb.net/yaowen/2013/0530/141681.shtml","http://www.chinanews.com/gn/2013/05-29/4871496.shtml"};
//				for(int i=0; i<titles.length; i++){
//					Article article = new Article();
//					article.setTitle(titles[i]);
//					article.setPicUrl(picUrls[i]);
//					article.setDescription(desps[i]);
//					article.setUrl(urls[i]);
//					articles.add(article);
//				}	
				Article article = new Article();
				article.setTitle("有街惠，不团购");
				article.setPicUrl("http://www.ijiehui.com/images/33.jpg");
				article.setDescription("有街惠，不团购。今日限时特惠就在身边；无需预约，立即享受；到店付钱，省钱又保质");
				article.setUrl("http://www.ijiehui.com");
				articles.add(article);
				Document doc = Jsoup.connect("http://news.ifeng.com/exclusive/official/special/clist_0/1.shtml").get(); 
				Iterator<Element> iterator = doc.getElementsByClass("box02_1").iterator();
				while(iterator.hasNext()){
					Element ele = iterator.next();
					Article myAticle = new Article();
					myAticle.setTitle(ele.getElementsByTag("p").first().textNodes().get(0).text());
					myAticle.setPicUrl(ele.getElementsByTag("img").first().attr("src"));		
					//myAticle.setDescription(ele.getElementsByTag("p").first().textNodes().get(0).text());
					myAticle.setUrl(ele.getElementsByTag("h3").first().getElementsByTag("a").attr("href"));
					articles.add(myAticle);
				}
				resp.setArticleCount(String.valueOf(articles.size()));
				resp.setArticles(articles);			
			}
			else{
				resp.setContent(ChatRobot.chat(content));
				resp.setMsgType("text");
			}					
		}
		else if("image".equalsIgnoreCase(reqXml.getMsgType())){
			
			String picUrl = reqXml.getPicUrl();
			resp.setContent(ChatRobot.chatImg(picUrl));
			resp.setMsgType("text");
			
		}
		else if("location".equalsIgnoreCase(reqXml.getMsgType())){
			
			List<Article> articles = new ArrayList<Article>();
			resp.setMsgType("news");
			resp.setArticles(articles);	
			String lat = reqXml.getLocation_X();
			String lon = reqXml.getLocation_Y();
			String label = reqXml.getLabel();
			List<Map<String, Object>> ret = WeixinUtil.getLocationCoupon(lat, lon, label);
			int i = 0;
			for(Map<String, Object> map : ret){
				Article myAticle = new Article();
				myAticle.setTitle((String)map.get("name"));
				String picUrl = (String)map.get("picUrl1");
				if(i == 0){
					if(picUrl.startsWith("sp_")){
						picUrl = "bp_" + picUrl.substring(3);
					}	
				}				
				myAticle.setPicUrl(picUrl);		
				myAticle.setDescription((String)map.get("detail"));
				//myAticle.setUrl(ele.getElementsByTag("h3").first().getElementsByTag("a").attr("href"));
				articles.add(myAticle);
				i++;
			}
			
			resp.setArticleCount(String.valueOf(articles.size()));
			
		}
		else if("link".equalsIgnoreCase(reqXml.getMsgType())){
			
		}
		else if("event".equalsIgnoreCase(reqXml.getMsgType())){
			if("subscribe".equalsIgnoreCase(reqXml.getEvent())){
				resp.setContent("欢迎关注街惠公众账号, 官方主页: http://www.ijiehui.com");
				resp.setMsgType("text");
//				resp.setMsgType("news");
//				resp.setArticleCount("1");
//				List<Article> articles = new ArrayList<Article>();
//				Article article = new Article();
//				article.setTitle("有街惠，不团购");
//				article.setPicUrl("http://www.ijiehui.com/images/33.jpg");
//				article.setDescription("有街惠，不团购。今日限时特惠就在身边；无需预约，立即享受；到店付钱，省钱又保质");
//				article.setUrl("http://www.ijiehui.com");
//				articles.add(article);
//				resp.setArticles(articles);
			}
			else if("unsubscribe".equalsIgnoreCase(reqXml.getEvent())){
				resp.setContent("感谢您对街惠公众账号的支持，期待您再次关注");
				resp.setMsgType("text");
			}
		}
		
		logger.info(ReflectionToStringBuilder.toString(resp));
		
       
        logger.info(WeixinUtil.<WeixinMessageRespVo>object2XML(resp));  
		
		return resp;
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="testXML.do")
	public WeixinMessageRespVo testXML(HttpServletRequest request) throws NoSuchAlgorithmException, IOException{		
		
		WeixinMessageRespVo resp = new WeixinMessageRespVo();
		resp.setContent("1");
		resp.setCreateTime("1");
		resp.setFromUserName("1");
		resp.setFuncFlag("1");
		resp.setMsgType("1");
		resp.setToUserName("1");	
		
		return resp;
		
		
	}

}
