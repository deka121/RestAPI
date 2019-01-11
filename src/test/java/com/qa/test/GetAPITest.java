package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.api.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase {

	TestBase testBase;
	String Serviceurl ;
	String apiURL;
	String url;
	RestClient restClient;
	
@BeforeMethod
public void setup() throws ClientProtocolException, IOException {
	testBase  = new TestBase();
	Serviceurl = prop.getProperty("URL");
	apiURL= prop.getProperty("serviceURL");
	url = Serviceurl+apiURL;
}
	@Test
	public void getAPITest() throws ClientProtocolException, IOException
	{
	    restClient = new RestClient();
		restClient.get(url);
	}

}
