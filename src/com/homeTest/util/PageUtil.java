package com.homeTest.util;


public class PageUtil {
	
	private int sizePage;//姣忎釜椤甸潰鏄剧ず澶氬皯锟�?
	private int nowPage;//褰撳墠椤甸潰
	private int rowCount;//锟�?锟斤拷鏈夊灏戞潯璁板綍
	private int pageCount;//锟�?锟斤拷鏈夊灏戦〉
	private int upPage;//涓婁竴锟�?
	private int downPage;//涓嬩竴锟�?
	private int firstPage;//棣栭〉
	private int lastPage;//灏鹃〉
	private int stratPage;//璧峰锟�?
	public PageUtil(int sizePage, int nowPage, int rowCount){
		this.sizePage = sizePage;
		this.nowPage = nowPage;
		this.rowCount = rowCount;
		this.pageCount = rowCount%sizePage==0?rowCount/sizePage:rowCount/sizePage+1;
		this.firstPage = 1;
		this.lastPage = pageCount;
		if(nowPage==firstPage){
			this.upPage=firstPage;
		}else{
			this.upPage = nowPage-1;
		}
		if(nowPage==lastPage){
			this.downPage=lastPage;
		}else{
			this.downPage = nowPage+1;
		}
		this.stratPage = (nowPage-1)*sizePage;
	}
	
	public int getSizePage() {
		return sizePage;
	}
	public void setSizePage(int sizePage) {
		this.sizePage = sizePage;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getUpPage() {
		return upPage;
	}
	public void setUpPage(int upPage) {
		this.upPage = upPage;
	}
	public int getDownPage() {
		return downPage;
	}
	public void setDownPage(int downPage) {
		this.downPage = downPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStratPage() {
		return stratPage;
	}
	public void setStratPage(int stratPage) {
		this.stratPage = stratPage;
	}
	@Override
	public String toString() {
		return "PageUtil [sizePage=" + sizePage + ", nowPage=" + nowPage + ", rowCount=" + rowCount + ", pageCount="
				+ pageCount + ", upPage=" + upPage + ", downPage=" + downPage + ", firstPage=" + firstPage
				+ ", lastPage=" + lastPage + ", stratPage=" + stratPage + "]";
	}

	public PageUtil() {
	}
}
