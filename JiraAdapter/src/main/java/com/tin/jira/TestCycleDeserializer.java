package com.tin.jira;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class TestCycleDeserializer implements JsonDeserializer<TestCycle> {
	
	
	public TestCycle deserialize(JsonElement el, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		
		TestCycle testCycle = new TestCycle();
				
		final JsonObject obj = el.getAsJsonObject();
		testCycle.setTotal(obj.get("total").getAsDouble());
		
		final JsonArray issuesArr = obj.getAsJsonArray("issues");
		
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		
		for(Object item: issuesArr) {
			
			builder.registerTypeAdapter(Issue.class, new IssueDeserializer());
			Gson gson = builder.create();
			
			final JsonObject issueJsonObj = (JsonObject) item;
			
			Issue issue = gson.fromJson(issueJsonObj, Issue.class);
					
			testCycle.getIssueList().add(issue);
			
		}
		
		return testCycle;
	}
	
	
		
	
}
