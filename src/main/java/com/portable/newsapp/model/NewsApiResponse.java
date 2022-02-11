package com.portable.newsapp.model;

import java.util.List;

/**
 * An object encapsulating the data returned by a News API.
 * @author deepak
 */
public interface NewsApiResponse {

	public int getTotalResults();
	public int getStartIndex();
	public int getPageSize();
	public int getCurrentPage();
	public int getPages();
	public String getOrderBy();
	public List<NewsApiArticle> getResults();
	
}
