package cn.com.widemex.streetDiscount.shopPlatform.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
public class WeixinMessageReqVo {
	
	private String ToUserName;
	
	private String FromUserName;
	
	private String CreateTime;
	
	private String MsgType;
	
	private String Content;
	
	private String PicUrl;
	
	private String Location_X;
	
	private String Location_Y;
	
	private String Scale;
	
	private String Label;
	
    private String Title;
	
	private String Description;
	
	private String Url;
	
    private String Event;
	
	private String EventKey;
	
	private String MsgId;

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

	@XmlElement(name="MsgId")
	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	@XmlElement(name="PicUrl")
	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	@XmlElement(name="Location_X")
	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	@XmlElement(name="Location_Y")
	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	@XmlElement(name="Scale")
	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	@XmlElement(name="Label")
	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	@XmlElement(name="Title")
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	@XmlElement(name="Description")
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@XmlElement(name="Url")
	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	@XmlElement(name="Event")
	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	@XmlElement(name="EventKey")
	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	
	
	
	

}
