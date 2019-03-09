package cn.comesaday.cw.utils;

import java.util.List;

import cn.comesaday.cw.entity.User;

public class PageBean {

	private int totalCount;
	private int pageSize = 10;
	private int totalPage;
	private int currentPage;
	private List<User> list;
	
	private boolean hasFirst;
	private boolean hasLast;
	private boolean hasPre;
	private boolean hasNext;
	
	public PageBean(int totalCount, List<User> list, int pageSize, int currentPage) {
		this.totalCount = totalCount;
		this.list = list;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		if (totalCount == 0) {
			return 1;
		}
		return totalCount % pageSize != 0 ? (totalCount / pageSize + 1) : (totalCount / pageSize);
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	
	public boolean isHasFirst() {
		return currentPage > 1 ? true : false;
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	public boolean isHasLast() {
		return currentPage < totalPage ? true :false;
	}

	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}

	public boolean isHasPre() {
		return isHasFirst();
	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

	public boolean isHasNext() {
		return isHasLast();
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
}
