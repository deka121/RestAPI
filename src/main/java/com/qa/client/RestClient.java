package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	//1.Get method - how to create 
	
	    public void get(String url) throws ClientProtocolException, IOException {
	
		CloseableHttpClient httpclient = HttpClients.createDefault();  //it will create a client connection
		HttpGet  httpget = new HttpGet(url); // it will create a  get connection with the given URL, its a http get request 
		CloseableHttpResponse closeabehttpresponse = httpclient.execute(httpget); //http get request we need to pass it as argument(hit the API) - Hit the get url
		
		//2.To get the Status code 
		int statuscode = closeabehttpresponse.getStatusLine().getStatusCode();
	    System.out.println("status code---------->" + statuscode);
	    
	    //3.To get the Response
	    String responseSring = EntityUtils.toString(closeabehttpresponse.getEntity(),  "UTF-8"); // using EntityUtils we can parse response
    
	    //4.To Convert in to JSON file
	    JSONObject  responsejson = new JSONObject (responseSring);
	    System.out.println(" Response Json from API : "+responsejson);
	    	    
	    //5. To Get All Header 
	    Header[] headerArray = closeabehttpresponse.getAllHeaders();
       //we can use hashmap - in hashmap its easy to iterate value since its store in key and value format
	     HashMap<String, String> allHeader = new HashMap <String, String>();
	      for(Header header : headerArray)
	     {
	    	 allHeader.put(header.getName() , header.getValue());
	   	     }
	     	   System.out.println("Header Array is :" + allHeader);
	}
	
	
	

}
