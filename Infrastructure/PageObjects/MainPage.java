package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage 
{
     @FindBy(id="gh-ac")
     public WebElement searchBox;

     @FindBy(id="gh-cat")
     public WebElement selectCategory;	
	
     @FindBy(id="gh-btn")
     public WebElement searchButton;
}
