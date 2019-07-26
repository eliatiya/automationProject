package Utilities;

import org.openqa.selenium.support.PageFactory;

import PageObjects.MainPage;
import PageObjects.ResultsPage;

public class managePages extends base {

	public static void init()
	{
	    ebayMain=PageFactory.initElements(driver, MainPage.class);
		ebayResult=PageFactory.initElements(driver, ResultsPage.class);
	}
	
}
