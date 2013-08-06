package com.guibo.fenshi.msp.vo;

import java.io.Serializable;

/**
 * @author Guan Yu Cai
 *
 */
public class CouponDynamic implements Serializable {
	private static final long serialVersionUID = 8661480333607439846L;
	private long couponId;
	private int visiteNum;
	private int visiteTemp;
	private int joinNum;
	private int joinTemp;
	private int likeNum;
	private int likeTemp;
	private int dislikeNum;
	private int dislikeTemp;
	private int buyNum;
	private int buyTemp;
	private int favoriteNum;
	private int favoriteTemp;
	
	public long getCouponId() {
		return couponId;
	}
	
	public void setCouponId(long couponId) {
		this.couponId = couponId;
	}
	
	public int getVisiteNum() {
		return visiteNum;
	}
	
	public void setVisiteNum(int visiteNum) {
		this.visiteNum = visiteNum;
	}
	
	public int getVisiteTemp() {
		return visiteTemp;
	}
	
	public void setVisiteTemp(int visiteTemp) {
		this.visiteTemp = visiteTemp;
	}
	
	public int getJoinNum() {
		return joinNum;
	}
	
	public void setJoinNum(int joinNum) {
		this.joinNum = joinNum;
	}
	
	public int getJoinTemp() {
		return joinTemp;
	}
	
	public void setJoinTemp(int joinTemp) {
		this.joinTemp = joinTemp;
	}
	
	public int getLikeNum() {
		return likeNum;
	}
	
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	
	public int getLikeTemp() {
		return likeTemp;
	}
	
	public void setLikeTemp(int likeTemp) {
		this.likeTemp = likeTemp;
	}
	
	public int getDislikeNum() {
		return dislikeNum;
	}
	
	public void setDislikeNum(int dislikeNum) {
		this.dislikeNum = dislikeNum;
	}
	
	public int getDislikeTemp() {
		return dislikeTemp;
	}
	
	public void setDislikeTemp(int dislikeTemp) {
		this.dislikeTemp = dislikeTemp;
	}
	
	public int getBuyNum() {
		return buyNum;
	}
	
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	
	public int getBuyTemp() {
		return buyTemp;
	}
	
	public void setBuyTemp(int buyTemp) {
		this.buyTemp = buyTemp;
	}
	
	public int getFavoriteNum() {
		return favoriteNum;
	}
	
	public void setFavoriteNum(int favoriteNum) {
		this.favoriteNum = favoriteNum;
	}
	
	public int getFavoriteTemp() {
		return favoriteTemp;
	}
	
	public void setFavoriteTemp(int favoriteTemp) {
		this.favoriteTemp = favoriteTemp;
	}	
}
