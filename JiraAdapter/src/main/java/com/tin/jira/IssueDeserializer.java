package com.tin.jira;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class IssueDeserializer implements JsonDeserializer<Issue> {

	public Issue deserialize(JsonElement el, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		
		Issue issue = new Issue();
		JsonObject issueJsonObj = el.getAsJsonObject();		
		issue.setId(issueJsonObj.get("id").getAsString());
		issue.setKey(issueJsonObj.get("key").getAsString());
		
		deserializeIssueFields(issue, issueJsonObj, context);
		
		
		return issue;
	}
	
	private void deserializeIssueFields(Issue issue, JsonObject issueJsonObj, 
										JsonDeserializationContext context) {
		
		final JsonElement issueFieldsEl = issueJsonObj.get("fields");
		final JsonObject fieldsJsonObj = issueFieldsEl.getAsJsonObject();
		
		issue.setDescription(fieldsJsonObj.get("description").getAsString());
		issue.setUpdated((Date)context.deserialize(fieldsJsonObj.get("updated"), Date.class));
				
	}
	

}
