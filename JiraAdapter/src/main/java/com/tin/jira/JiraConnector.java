package com.tin.jira;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class JiraConnector {
	
	private String url;
	private StringBuffer rawData;
	
	public JiraConnector(String url) {
		this.url = url;
	}
	
	
		
	public String getUrl() {
		return url;
	}




	public StringBuffer getRawData() {
		return rawData;
	}




	public void fetch() throws Exception {
		CloseableHttpResponse response = connect();
		 BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
		 String line = "";
		 rawData = new StringBuffer();
		 while ((line = rd.readLine()) != null) {
		     rawData.append(line);
		   }
		 rd.close();
	}
	
	private CloseableHttpResponse connect() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet( getUrl() );
		CloseableHttpResponse response = client.execute(request);
		return response;
	}
	
	

}
