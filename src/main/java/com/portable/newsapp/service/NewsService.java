package com.portable.newsapp.service;

import com.portable.newsapp.model.NewsApiResponse;

/**
 * An interface which may be implemented to get articles from a news API
 */
public interface NewsService {

	/**
	 * Search for articles based on a search term
	 * @param searchTerm - A term to search for
	 * @param pageNo - The page number of the resultset
	 * @return a NewsApiResponse object containing search results
	 */
	public NewsApiResponse searchArticles(String searchTerm, Integer pageNo);
	
}
