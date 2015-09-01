package com.tin.jira;

import java.text.SimpleDateFormat;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws Exception
    {
    	
    	JiraAdapter adapter = new JiraAdapter("http://localhost:3000/jira_get_test_cycle_by_id_via_jql.json","MCP-25047");
		adapter.process();
		TestCycle testCycle = adapter.getTestCycle();
		assertEquals( 8, testCycle.getIssueList().size());
		assertEquals( "381521", testCycle.getIssueList().get(0).getId());
		assertEquals(  "MCP-20981", testCycle.getIssueList().get(0).getKey());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		
		assertEquals( format.parse("2015-08-12T16:10:02.000+1000"), testCycle.getIssueList().get(0).getUpdated());
		assertEquals( true, testCycle.getIssueList().get(0).getSanitisedDescription().contains("<p>Scenario Outline: MCP-20981 Inside Retrieve for Buildings<br />"));
		
        assertTrue( true );
    }
}
