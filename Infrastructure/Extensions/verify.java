package Extensions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.commonOps;

public class verify  extends commonOps
{
	public static void textInElement(WebElement elem , String expected) throws IOException, ParserConfigurationException, SAXException
	{
		try {	
		assertEquals(elem.getText(), expected);
		test.log(LogStatus.PASS,"assertion success");
		}
		catch (Exception e)
		{
			System.out.println("falid to assert, see details:  " + e + "see ScreenShut : " + test.addScreenCapture( takeSS()));
			fail("failed to assert");
		}
		catch (AssertionError e) 
		{
			test.log(LogStatus.FAIL,"falid to assert, see details:  " + e + "see ScreenShut : "+ test.addScreenCapture( takeSS()));
			fail("failed to assert");
		}
	}
	
	public static void image(String imagePath) throws IOException, ParserConfigurationException,FindFailed , SAXException{
		try{
			screen.find(imagePath);
			test.log(LogStatus.PASS,"image found in successfully");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"failed to find image, see details:  " + e + "see ScreenShut : "+ test.addScreenCapture( takeSS()));
			fail("failed to find image");
			
		}
		
	}
	public static void contains(String response, String text) throws IOException, ParserConfigurationException,FindFailed , SAXException{
		try{
			assertTrue(response.contains(text));
			test.log(LogStatus.PASS,"contains Passed Successfully");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,text + "failed to contained, see details:  " + e);
			fail("failed to contained");
			
		}
		
	}
}
