package Extensions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.commonOps;

public class elementUnderElement extends commonOps{

	public List<WebElement> findElementInElement(WebElement parent ,By by){
		List<WebElement> elementToFind = null ; 
		try {
			elementToFind = parent.findElements(by);
			//extendreport
		}
		catch(Exception e) {
			//wait for element 
			elementToFind = parent.findElements(by);
			//extendreport
		}
		return elementToFind;
	}

}
