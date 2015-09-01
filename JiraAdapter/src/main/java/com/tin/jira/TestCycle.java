package com.tin.jira;

import java.util.ArrayList;
import java.util.List;

public class TestCycle {
	
	Double total;
	List<Issue> issueList;
	
	public TestCycle() {
		issueList = new ArrayList<Issue>();
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<Issue> getIssueList() {
		return issueList;
	}

	
	
	
	

}
