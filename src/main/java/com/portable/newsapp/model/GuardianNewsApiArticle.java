package com.portable.newsapp.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.portable.newsapp.model.guardian.GuardianArticle;

/**
 * Implementation of the NewsApiArticle interface for the Guardian API
 */
public class GuardianNewsApiArticle implements NewsApiArticle {

	private static final Logger log = LoggerFactory.getLogger(GuardianNewsApiArticle.class);
	
	private GuardianArticle article;
	
	public GuardianNewsApiArticle(GuardianArticle article) {
		this.article = article;
	}

	@Override
	public String getId() {
		return this.article.getId();
	}

	@Override
	public String getSectionId() {
		return this.article.getSectionId();
	}

	@Override
	public String getSectionName() {
		return this.article.getSectionName();
	}

	@Override
	public String getPublicationDate() {
		String dateTimeStr = this.article.getWebPublicationDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
		try {
			Date dt = sdf.parse(dateTimeStr);
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			dateTimeStr = sdf2.format(dt);
		} catch (ParseException e) {
			log.error("Error parsing date", e);
			dateTimeStr = "";
		}
		
		return dateTimeStr;
	}

	@Override
	public String getTitle() {
		return this.article.getWebTitle();
	}

	@Override
	public String getUrl() {
		return this.article.getWebUrl();
	}

}
