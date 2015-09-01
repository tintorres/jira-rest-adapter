package com.tin.jira;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JiraAdapter {
	String testCycleId;
	String uri;
	JiraConnector connector;
	TestCycle testCycle;
	
	
	public JiraAdapter(String uri, String testCycleId) {
		this.uri = uri;
		this.testCycleId = testCycleId;
	}
	
	public void process() {
		try {
			connector = new JiraConnector(getUrl());	
			connector.fetch();
			parse();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void parse() throws Exception {
		GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder
							.registerTypeAdapter(TestCycle.class, new TestCycleDeserializer())
							.create();
		testCycle = gson.fromJson(getRawData().toString(), TestCycle.class);
	}
	
	private String getUrl() {
		String jql = "id=" + this.testCycleId;
		return uri + "?" + jql;
	}
	
			
	public StringBuffer getRawData() {
		return this.connector.getRawData();
	}
	
	public TestCycle getTestCycle() {
		return testCycle;
	}
}
