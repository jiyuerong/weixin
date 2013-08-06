package cn.com.widemex.streetDiscount.shopPlatform.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
public class WeixinMessageRespVo {
	
	private String ToUserName;
	
	private String FromUserName;
	
	private String CreateTime;
	
	private String MsgType;
	
	private String Content;
	
	private String MusicUrl;
	
	private String HQMusicUrl;
	
	private String ArticleCount;
	
	private List<Article> Articles;
	
	private String FuncFlag;

	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	@XmlElement(name="FromUserName")
	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	@XmlElement(name="CreateTime")
	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	@XmlElement(name="MsgType")
	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	@XmlElement(name="Content")
	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@XmlElement(name="FuncFlag")
	public String getFuncFlag() {
		return FuncFlag;
	}

	public void setFuncFlag(String funcFlag) {
		FuncFlag = funcFlag;
	}

	@XmlElement(name="MusicUrl")
	public String getMusicUrl() {
		return MusicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}

	@XmlElement(name="HQMusicUrl")
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	@XmlElement(name="ArticleCount")
	public String getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}

	@XmlElementWrapper(name="Articles")
	@XmlElement(name="item")
	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

	
	

}
