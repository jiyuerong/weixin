package cn.com.widemex.streetDiscount.shopPlatform.vo;

public class PageableQuery {

	
	private int page = 1;
	private int rp = 10; 
	private int totalPage;
	private String sortName;
	private String sortOrder; 
	private String queryConditions;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRp() {
		return rp;
	}
	public void setRp(int rp) {
		this.rp = rp;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getQueryConditions() {
		return queryConditions;
	}
	public void setQueryConditions(String queryConditions) {
		this.queryConditions = queryConditions;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
	
}
