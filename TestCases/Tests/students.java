package Tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.verify;
import Utilities.commonOps;
import WorkFlows.api_actions;

public class students extends commonOps 
{
@Test
public void test01_VerifyStudentCreated() throws ParserConfigurationException, SAXException, IOException, FindFailed 
{
	api_actions.postNewStudent();
	verify.contains(api_actions.getDetails().getBody().asString(), "eliatiya770@gmail.com");
}	
}
