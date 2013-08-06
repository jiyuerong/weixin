package cn.com.widemex.streetDiscount.shopPlatform.util;

import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.guibo.fenshi.msp.vo.CouponDynamic;

@Component
public class MemcachedUtil {

	@Autowired
	private ProjectProperties projectProperties;
	
	private MemCachedClient mc; 
	
	@PostConstruct
	public void init(){
		SockIOPool pool = SockIOPool.getInstance(this.projectProperties.getCachePoolName());
		pool.setServers(new String[]{this.projectProperties.getCacheServerName()});
		pool.setInitConn(this.projectProperties.getCacheInitConn());
		pool.setMinConn(this.projectProperties.getCacheMinConn());
		pool.setMaxConn(this.projectProperties.getCacheMaxConn());
		pool.setMaintSleep(this.projectProperties.getCacheMaintSleep());
		pool.setNagle(false);
		pool.initialize();

		// get client instance
		mc = new MemCachedClient(this.projectProperties.getCachePoolName());
		//mc.set("123", "1");
		//System.out.println("======================cache==========" + mc.get("curr_coupon_ids"));
		//System.out.println("======================cache==========" + mc.get("123"));
	}
	
	public void shutDown() {
		SockIOPool.getInstance(this.projectProperties.getCachePoolName()).shutDown();
	}

	/**
	 * 返回memcached状态
	 * */
	public Map<String, Map<String, String>> status() {
		return mc.stats();
	}

	public CouponDynamic getCacheCouponDynamic(String couponId){
		
		return (CouponDynamic)mc.get("favorite_dynamic" + couponId);
	}
	
	public boolean delete(String key) {
		return mc.delete(key, null, null);
	}

	public boolean delete(String key, Date expiry) {
		return mc.delete(key, null, expiry);
	}

	public boolean delete(String key, Integer hashCode, Date expiry) {
		return mc.delete(key, hashCode, expiry);
	}

	public boolean set(String key, Object value) {
		return mc.set(key, value);
	}

	public boolean set(String key, Object value, Integer hashCode) {
		return mc.set(key, value, hashCode);
	}

	public boolean set(String key, Object value, Date expiry) {
		return mc.set(key, value, expiry);
	}

	public boolean set(String key, Object value, Date expiry, Integer hashCode) {
		return mc.set(key, value, expiry, hashCode);
	}

	public Object get(String key) {
		return mc.get(key);
	}

	public Object[] get(String[] keys) {
		return mc.getMultiArray(keys);
	}

	public boolean flushAll() {
		return mc.flushAll();
	}

	public boolean flushAll(String[] keys) {
		return mc.flushAll(keys);
	}

	
}
