package com.portable.newsapp.model;

import java.util.ArrayList;
import java.util.List;

import com.portable.newsapp.model.guardian.GuardianArticle;
import com.portable.newsapp.model.guardian.GuardianResponse;
import com.portable.newsapp.model.guardian.GuardianResponseWrapper;

public class GuardianNewsApiResponse implements NewsApiResponse {

	private GuardianResponse apiResponse;
	
	public GuardianNewsApiResponse(GuardianResponseWrapper responseWrapper) {
		apiResponse = responseWrapper.getResponse();
	}

	@Override
	public int getTotalResults() {
		return apiResponse.getTotal();
	}

	@Override
	public int getStartIndex() {
		return apiResponse.getStartIndex();
	}

	@Override
	public int getPageSize() {
		return apiResponse.getPageSize();
	}

	@Override
	public int getCurrentPage() {
		return apiResponse.getCurrentPage();
	}

	@Override
	public int getPages() {
		return apiResponse.getPages();
	}

	@Override
	public String getOrderBy() {
		return apiResponse.getOrderBy();
	}

	@Override
	public List<NewsApiArticle> getResults() {
		List<NewsApiArticle> result = new ArrayList<>();
		for (GuardianArticle article : apiResponse.getResults()) {
			result.add(new GuardianNewsApiArticle(article));
		}
		
		return result;
	}
}
