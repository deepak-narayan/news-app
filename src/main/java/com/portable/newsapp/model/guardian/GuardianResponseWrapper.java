package com.portable.newsapp.model.guardian;

/**
 * Wrapper for the response received from the Guardian API
 */
public class GuardianResponseWrapper {

	private GuardianResponse response;

	public GuardianResponseWrapper() {
		// Default Constructor
	}
	
	/**
	 * Get the actual response from the API
	 */
	public GuardianResponse getResponse() {
		return response;
	}

	public void setResponse(final GuardianResponse response) {
		this.response = response;
	}

	public GuardianResponseWrapper(final GuardianResponse response) {
		this.response = response;
	}
}
