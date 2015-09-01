package com.tin.jira;

import java.util.Date;

public class Issue {
	String id;
	String key;
	String description;
	Date updated;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public String getSanitisedDescription() {
		String gherkin = getDescription();
		
		gherkin = gherkin.replaceAll("/\\/", "###BACKSLASH###");
		gherkin = gherkin.replaceAll("/<p [^>]+>/", "");
		gherkin = gherkin.replaceAll("/</p>/", "\n");
		gherkin = gherkin.replaceAll("/<b [^>]+>/", "");
		gherkin = gherkin.replaceAll("/<table[^>]+>/", "");
		gherkin = gherkin.replaceAll("/</table[^>]*>/", "");
		gherkin = gherkin.replaceAll("/<span[^>]+>/", "");
		gherkin = gherkin.replaceAll("/</span[^>]*>/", "");
		gherkin = gherkin.replaceAll("/</div[^>]*>/", "\n");
		gherkin = gherkin.replaceAll("/<div[^>]*>/", "");
		gherkin = gherkin.replaceAll("/<[ubpi]>/", "");
		gherkin = gherkin.replaceAll("/</p>/", "\n");
		gherkin = gherkin.replaceAll("/</[ubi]>/", "");
		gherkin = gherkin.replaceAll("&nbsp;", " ");
		gherkin = gherkin.replaceAll("&quot;", "\"");
		gherkin = gherkin.replaceAll("/\t/", "");
		gherkin = gherkin.replaceAll("/<br />/", "\n");
		gherkin = gherkin.replaceAll("/\r\n/", "\n");
		gherkin = gherkin.replaceAll("/\n\r/", "\n");
		gherkin = gherkin.replaceAll("/\n\n/", "\n");
		gherkin = gherkin.replaceAll("/\n\n/", "\n");
		gherkin = gherkin.replaceAll("/\n\n/", "\n");

		return gherkin;		
	}
	
	 
	
}
