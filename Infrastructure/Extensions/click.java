package Extensions;

import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.commonOps;

public class click extends commonOps {

	public static void clickAndGo(WebElement elem) throws IOException, ParserConfigurationException, SAXException
	{
		try {	
		elem.click();
		test.log(LogStatus.PASS,"elemet clicked successfully" );
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL,"failed to click on Element, see details:  " + e + "see ScreenShut : "+ test.addScreenCapture( takeSS()));
			fail("failed to click on Element");
		}
	}
	
}
