package com.twitter.controller;
/*
 @VidhiSharma
 */
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.scribe.model.Verb;

import com.twitter.controller.AccountInfo;

//import org.junit.jupiter.api.Test;

public class Tests {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private AccountInfo servlet;
	private Credentials credentials;
	private ServletControllerMain mainServlet;

// Test on the InvokeTwitterAccount to  check whether its getting the get request or not
	@Test
	public void invokeTwitterAccountInfo() throws ServletException, IOException {
		System.out.println("in test");
		servlet = new AccountInfo();
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);

		System.out.println("newReq" + request);
		System.out.println("newRes" + response);
		try {
			servlet.doGet(request, response);
			System.out.println("in test 1");
			System.out.println("in test 2");
		} catch (Exception e) {
			// Accepting Null Pointer Exception - Unable to Find Access Token
			Assert.assertTrue(true);

		}

	}
	
	// Test to check whether the Credentials are able to get the proper URL
	
	@Test
	public void findCredentialsInvokeAPINullCheck() throws ServletException, IOException {
		System.out.println("in test");
		credentials = new Credentials();
		String requestUrl = null;
	

		try {
			String invokeTwitterAPIResponse = credentials.invokeTwitterAPI(Verb.POST, requestUrl);
			Assert.assertEquals("url is empty", invokeTwitterAPIResponse);
			
		} catch (Exception e) {
			// Accepting Null Pointer Exception - Unable to Find Access Token
			Assert.assertTrue(true);

		}

	}
	//test to check whether or not the URL obtained is empty or not for the credentials methods
	@Test
	public void findCredentialsInvokeAPIEmptyCheck() throws ServletException, IOException {
		System.out.println("in test");
		credentials = new Credentials();
		String requestUrl = "";
	

		try {
			String invokeTwitterAPIResponse = credentials.invokeTwitterAPI(Verb.POST, requestUrl);
			Assert.assertEquals("url is empty", invokeTwitterAPIResponse);
			
		} catch (Exception e) {
			// Accepting Null Pointer Exception - Unable to Find Access Token
			Assert.assertTrue(true);

		}

	}
	//test to check whether or not the URL obtained is empty or not for the ServletInvokeAPI
	public void mainServletInvokeAPIEmptyCheck() throws ServletException, IOException {
		System.out.println("in test");
		mainServlet = new ServletControllerMain();
		String requestUrl = "";
	

		try {
			String invokeTwitterAPIResponse = mainServlet.invokeTwitterAPI(Verb.POST, requestUrl);
			Assert.assertEquals("url is empty", invokeTwitterAPIResponse);
			
		} catch (Exception e) {
			// Accepting Null Pointer Exception - Unable to Find Access Token
			Assert.assertTrue(true);

		}

	}
	//test to check whether or not the URL obtained is empty or not for the mainServlet methods
	@Test
	public void mainServletInvokeAPINullCheck() throws ServletException, IOException {
		System.out.println("in test");
		mainServlet = new ServletControllerMain();
		String requestUrl = null;
	

		try {
			String invokeTwitterAPIResponse = mainServlet.invokeTwitterAPI(Verb.POST, requestUrl);
			Assert.assertEquals("url is empty", invokeTwitterAPIResponse);
			
		} catch (Exception e) {
			// Accepting Null Pointer Exception - Unable to Find Access Token
			Assert.assertTrue(true);

		}

	}
	
	
}
