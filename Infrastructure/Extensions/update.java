package Extensions;

import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.commonOps;

public class update extends commonOps {
	public static void text(WebElement elem ,String value) throws IOException, ParserConfigurationException, SAXException
	{
		try {	
		elem.sendKeys(value);
		test.log(LogStatus.PASS,"text filed updated successfully");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL,"failed to update text field, see details:  " + e + "see ScreenShut : " + test.addScreenCapture( takeSS()));
			fail("failed to update text field");
		}
	}
	public static void drpoDownText(WebElement elem ,String value) throws IOException, ParserConfigurationException, SAXException
	{
		try {	
		Select myValue = new Select(elem);
		myValue.selectByVisibleText(value);
		test.log(LogStatus.PASS,"text field updated successfully");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL,"failed to update text field, see details:  " + e + "see ScreenShut : " + test.addScreenCapture( takeSS()));
			fail("failed to update text field");
		}
	
	}
}
