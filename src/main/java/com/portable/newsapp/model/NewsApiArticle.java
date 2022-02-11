package com.portable.newsapp.model;

/**
 * Interface representing a news article
 */
public interface NewsApiArticle {

	public String getId();

	public String getSectionId();

	public String getSectionName();

	public String getPublicationDate();

	public String getTitle();

	public String getUrl();
}