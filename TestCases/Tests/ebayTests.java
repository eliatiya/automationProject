package Tests;


import java.io.IOException;


import javax.xml.parsers.ParserConfigurationException;

import org.sikuli.script.FindFailed;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.verify;
import Utilities.commonOps;

import WorkFlows.db_query;
import WorkFlows.web_search;
public class ebayTests extends commonOps {
  	@Test
	public void Test1_searchValue() throws IOException, ParserConfigurationException, SAXException, FindFailed{
		web_search.go("bmwnew", "Baby");
	//	verify.textInElement(ebayResult.resultField, "0 results found for bmwnew, so we searched for bmw new");
		verify.image("./ImageRepository/ebayLogo.png");
		
	}
  	@Test
  	public void Test2_searchValueDB() throws IOException, ParserConfigurationException, SAXException, FindFailed
  	{
		web_search.go("MARY", "Baby");
		verify.textInElement(ebayResult.resultField, db_query.getMessage("customer_id", "MARY"));
	}
}