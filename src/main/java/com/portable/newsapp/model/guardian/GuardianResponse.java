package com.portable.newsapp.model.guardian;

import java.util.List;

/**
 * Response object from the Guardian API
 */
public class GuardianResponse {

	private String status;
	private String userTier;
	private int total;
	private int startIndex;
	private int pageSize;
	private int currentPage;
	private int pages;
	private String orderBy;
	private List<GuardianArticle> results;

	public GuardianResponse() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserTier() {
		return userTier;
	}

	public void setUserTier(String userTier) {
		this.userTier = userTier;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public List<GuardianArticle> getResults() {
		return results;
	}

	public void setResults(List<GuardianArticle> results) {
		this.results = results;
	}
}
