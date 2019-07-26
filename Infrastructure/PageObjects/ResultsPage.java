package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage {
	 @FindBy(xpath="//*[@id='srp-river-results-message1']/div/p")
     public WebElement resultField;	
}
