package com.portable.newsapp.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.portable.newsapp.model.GuardianNewsApiResponse;
import com.portable.newsapp.model.NewsApiResponse;
import com.portable.newsapp.model.guardian.GuardianResponseWrapper;

/**
 * Service class for the Guardian API
 */

@Service
public class GuardianNewsService implements NewsService {

	private static final Logger log = LoggerFactory.getLogger(GuardianNewsService.class);
	
	@Value("${guardian.api.key}")
	private String apiKey;
	
	@Value("${guardian.api.endpoint}")
	private String endpoint;
	
    @Override
	public NewsApiResponse searchArticles(String searchTerm, Integer pageNo) {
    	log.debug("Get Guardian articles for term {}, page {}", searchTerm, pageNo);

    	// RestTemplate to query the Guardian REST API
		RestTemplate guardianApi = new RestTemplate();

		// Setup RestTemplate
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		StringBuilder url = new StringBuilder(endpoint);
		try {
			// Add the search term
			url.append("?q=").append(URLEncoder.encode(searchTerm, StandardCharsets.UTF_8.toString()));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(e);
		}
			
		// API Key
		url.append("&api-key=").append(apiKey);
			
		// If a page number has been specified
		if (pageNo != null) {
			url.append("&page=").append(pageNo);
		}
			
		ResponseEntity<GuardianResponseWrapper> resultObj = guardianApi.getForEntity(url.toString(), GuardianResponseWrapper.class);
			
		if (resultObj != null && resultObj.getStatusCode() == HttpStatus.OK) {
			return new GuardianNewsApiResponse(resultObj.getBody());
		} else {
			throw new IllegalStateException("An error occurred in the API call - " + resultObj.getStatusCodeValue());
		}
	}
}
