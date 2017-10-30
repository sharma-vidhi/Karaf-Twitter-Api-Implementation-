package com.twitter.controller;
/*
 @VidhiSharma
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

@WebServlet("/SearchTweets")
public class SearchTweets extends HttpServlet{
	
	protected OAuthService oAuthservice = null;
	protected Token accessTokenValue = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		accessTokenValue= (Token)session.getAttribute("accessToken");
		oAuthservice= (OAuthService)session.getAttribute("service");
		String requestUrl = "https://api.twitter.com/1.1/search/tweets.json?q=San%20Jose";
		request.setAttribute("searchTweets", invokeTwitterAPI(Verb.GET, requestUrl));
		request.getRequestDispatcher("/twitterSearch.jsp").forward(request, response);
	}
	
	public String invokeTwitterAPI(Verb httpMethod, String url) {
		String responseBody = "";
		System.out.println("Calling class");
		try {
			OAuthRequest request = new OAuthRequest(httpMethod, url);
			oAuthservice.signRequest(accessTokenValue, request);
			Response response = request.send();
			System.out.println(response.getBody());
			responseBody = response.getBody();

		} catch (Exception e) {
			System.out.println("Exception while serving twitter request" + e.getMessage());
		}
		return responseBody;

	}
	
}

