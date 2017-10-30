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

@WebServlet("/Followers")
public class Followers extends HttpServlet{
	
	private OAuthService oAuthservice = null;
	private Token accessTokenValue = null;

	private static final String FOLLOWERS_URL = "https://api.twitter.com/1.1/followers/list.json";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		accessTokenValue= (Token)session.getAttribute("accessToken");
		oAuthservice= (OAuthService)session.getAttribute("service");
		String requestUrl = "https://api.twitter.com/1.1/followers/list.json";
		request.setAttribute("followers", invokeTwitterAPI(Verb.GET, requestUrl));
		request.getRequestDispatcher("/showFollowers.jsp").forward(request, response);
	}

	protected String invokeTwitterAPI(Verb httpMethod, String url) {
		String responseBody = "";
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

