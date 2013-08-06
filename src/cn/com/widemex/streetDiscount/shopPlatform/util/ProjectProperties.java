package cn.com.widemex.streetDiscount.shopPlatform.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProjectProperties {

	@Value("${project.admin.role}")
	private String adminRole;
	
	@Value("${project.brand.admin}")
	private String brandAdminRole;
	
	@Value("${project.brand.operator}")
	private String brandOperatorRole;
	
	@Value("${project.shop.admin}")
	private String shopAdminRole;
	
	@Value("${project.shop.operator}")
	private String shopOperatorRole;
	
	@Value("${project.platform.admin}")
	private String platformAdminRole;
	
	@Value("${project.platform.operator}")
	private String platformOperatorRole;
	
	@Value("${project.platform.business}")
	private String platformBusinessRole;
	
	@Value("${project.shop.portal.menu.code}")
	private String shopPortal;
	
	@Value("${sensitive.word}")
	private String sensitiveWord;
	
	@Value("${sql.inject.word}")
	private String sqlInject;
	
	@Value("${opt.push.info.accs.length}")
	private int optPushInfoAccsLength;
	
	@Value("${push.info.accs.length}")
	private int pushInfoAccsLength;
	
	@Value("${sys.msg.push.expire.hours}")
	private int sysMsgPushExpireHours;
	
	@Value("${shop.msg.push.expire.hours}")
	private int shopMsgPushExpireHours;
	
	@Value("${term.msg.push.expire.hours}")
	private int termMsgPushExpireHours;
	
	@Value("${private.msg.push.expire.hours}")
	private int privateMsgPushExpireHours;
	
	@Value("${sys.msg.push.ring}")
	private short sysMsgPushRing;
	
	@Value("${shop.msg.push.ring}")
	private short shopMsgPushRing;
	
	@Value("${term.msg.push.ring}")
	private short termMsgPushRing;
	
	@Value("${private.msg.push.ring}")
	private short privateMsgPushRing;
	
	@Value("${opt.push.page.id}")
	private short optPushPageId;
	
	@Value("${personal.msg.push.page.id}")
	private short personMsgPushPageId;
	
	
	/**
	 * 平台管理员角色
	 * @return
	 */
	public String getPlatformAdminRole() {
		return platformAdminRole;
	}


	/**
	 * 平台运营员角色
	 * @return
	 */
	public String getPlatformOperatorRole() {
		return platformOperatorRole;
	}


	/**
	 * ftp服务器ip
	 */
	@Value("${ftp.server.ip}")
	private String ftpServerIP ;

	/**
	 * ftp服务器端�?
	 */
	@Value("${ftp.server.port}")
	private String ftpServerPort  ;

	/**
	 * ftp服务器用户名
	 */
	@Value("${ftp.server.user}")
	private String ftpServerUser ;
	/**
	 * ftp服务器密�?
	 */
	@Value("${ftp.server.password}")
	private String ftpServerPassword  ;

	/**
	 * ftp服务器文件存储临时目录：相对路径
	 */
	@Value("${ftp.server.savepath}")
	private String ftpDir ;
	/**
	 *  访问文件的url
	 */
	@Value("${ftp.server.url}")
	private String ftpVisitURL;
	/**
	 *  访问文件的url
	 */
	@Value("${ftp.server.midurl}")
	private String ftpVisitMidURL;
	/**
	 *  480 DPI width
	 */
	@Value("${image.dpi.four.width}")
	private int dpi480Width;

	/**
	 *   480 DPI height
	 */
	@Value("${image.dpi.four.width}")
	private  int dpi480Height;
	/**
	 *  640 DPI width
	 */
	@Value("${image.dpi.six.width}")
	private int dpi640Width;

	/**
	 *   640 DPI height
	 */
	@Value("${image.dpi.six.width}")
	private int dpi640Height;
	
	/**
	 * 缓存池名
	 */
	@Value("${cache.server.poolname}")
	private String cachePoolName;
	
	/**
	 * 缓存服务器名
	 */
	@Value("${cache.server.server}")
	private String cacheServerName;
	
	/**
	 * cache.server.poolMultiplier
	 */
	@Value("${cache.server.poolMultiplier}")
	private int cachePoolMultiplier;
	
	/**
	 * cache.server.initConn
	 */
	@Value("${cache.server.initConn}")
	private int cacheInitConn;
	
	@Value("${cache.server.minConn}")
	private int cacheMinConn;
	
	@Value("${cache.server.maxConn}")
	private int cacheMaxConn;
	
	@Value("${cache.server.maintSleep}")
	private long cacheMaintSleep;
	
	@Value("${cache.server.maxIdle}")
	private long cacheMaxIdle;
	
	@Value("${cache.server.maxBusyTime}")
	private long cacheMaxBusyTime;
	

	public String getAdminRole() {
		return adminRole;
	}


	public String getShopPortal() {
		return shopPortal;
	}


	public String getFtpServerIP() {
		return ftpServerIP;
	}


	public String getFtpServerPort() {
		return ftpServerPort;
	}


	public String getFtpServerUser() {
		return ftpServerUser;
	}


	public String getFtpServerPassword() {
		return ftpServerPassword;
	}


	public String getFtpDir() {
		return ftpDir;
	}


	public String getFtpVisitURL() {
		return ftpVisitURL;
	}


	public String getFtpVisitMidURL() {
		return ftpVisitMidURL;
	}


	public int getDpi480Width() {
		return dpi480Width;
	}


	public int getDpi480Height() {
		return dpi480Height;
	}


	public int getDpi640Width() {
		return dpi640Width;
	}


	public int getDpi640Height() {
		return dpi640Height;
	}


	public String getSensitiveWord() {
		return sensitiveWord;
	}


	public String getSqlInject() {
		return sqlInject;
	}


	public String getBrandAdminRole() {
		return brandAdminRole;
	}


	public String getBrandOperatorRole() {
		return brandOperatorRole;
	}


	public String getShopAdminRole() {
		return shopAdminRole;
	}


	public String getShopOperatorRole() {
		return shopOperatorRole;
	}


	public String getCachePoolName() {
		return cachePoolName;
	}


	public String getCacheServerName() {
		return cacheServerName;
	}


	public int getCachePoolMultiplier() {
		return cachePoolMultiplier;
	}


	public int getCacheInitConn() {
		return cacheInitConn;
	}


	public int getCacheMinConn() {
		return cacheMinConn;
	}


	public int getCacheMaxConn() {
		return cacheMaxConn;
	}


	public long getCacheMaintSleep() {
		return cacheMaintSleep;
	}


	public long getCacheMaxIdle() {
		return cacheMaxIdle;
	}


	public long getCacheMaxBusyTime() {
		return cacheMaxBusyTime;
	}


	public int getOptPushInfoAccsLength() {
		return optPushInfoAccsLength;
	}


	public int getSysMsgPushExpireHours() {
		return sysMsgPushExpireHours;
	}


	public short getSysMsgPushRing() {
		return sysMsgPushRing;
	}


	public short getShopMsgPushRing() {
		return shopMsgPushRing;
	}


	public int getShopMsgPushExpireHours() {
		return shopMsgPushExpireHours;
	}


	public int getPushInfoAccsLength() {
		return pushInfoAccsLength;
	}


	public int getTermMsgPushExpireHours() {
		return termMsgPushExpireHours;
	}


	public short getTermMsgPushRing() {
		return termMsgPushRing;
	}


	public short getOptPushPageId() {
		return optPushPageId;
	}


	public short getPersonMsgPushPageId() {
		return personMsgPushPageId;
	}


	public String getPlatformBusinessRole() {
		return platformBusinessRole;
	}


	public int getPrivateMsgPushExpireHours() {
		return privateMsgPushExpireHours;
	}


	public short getPrivateMsgPushRing() {
		return privateMsgPushRing;
	}

	
	
}
