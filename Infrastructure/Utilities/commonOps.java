package Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;


import io.restassured.RestAssured;

public class commonOps extends base
{
	@BeforeClass
	public void beforClass() throws ParserConfigurationException, SAXException, IOException {
		if(getData("automationType").toLowerCase().equals("web"))
			initBrowser("chrome");  
		else if(getData("automationType").toLowerCase().equals("api"))
			initApi();
		managePages.init();
		InstanceReport();  

	}

	@BeforeMethod
	public void beforMethod(Method method) {
		System.out.println("beforMethod");
		initReportTest(method.getName().split("_")[0], method.getName().split("_")[1]);

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
		finilizeReportTest();                                            
	}
	@AfterClass
	public void afterClass() throws ParserConfigurationException, SAXException, IOException {
		if(!getData("automationType").equals("api"))
			driver.quit();
		finilizeextentReport();
	}
	public static String getData(String nodeName) throws ParserConfigurationException, SAXException, IOException
	{
		File fXmlFile = new File("./ConfigurationProject.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile); 
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}

	public static void initBrowser(String browserType) throws ParserConfigurationException, SAXException, IOException
	{
		switch(browserType.toLowerCase())
		{
		case "chrome":
			driver = initChromeDriver();
			break;
		case "edge":
			driver = initEdgeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		screen = new Screen();
	}

	public static WebDriver initChromeDriver() throws ParserConfigurationException, SAXException, IOException
	{
		System.setProperty("webdriver.chrome.driver",getData("ChromeDriverPath"));
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public static WebDriver initEdgeDriver() throws ParserConfigurationException, SAXException, IOException
	{
		System.setProperty("webdriver.edge.driver",getData("MicrosoftWebDriver"));
		WebDriver driver = new EdgeDriver();
		return driver;
	}
	public static void initApi() throws ParserConfigurationException, SAXException, IOException
	{
		RestAssured.baseURI = getData("API_URL");
		httpRequest = RestAssured.given();
	}
	public static void InstanceReport() throws ParserConfigurationException, SAXException, IOException
	{
		extent = new ExtentReports(getData("ReportPath") + "Execution" + timeStamp + "/" + getData("ReportName") + ".html");
	}
	public static void initReportTest(String testName , String testDescription)
	{
		test = extent.startTest(testName,testDescription);
	}
	public static void finilizeReportTest()
	{
		extent.endTest(test);
	}
	public static void finilizeextentReport()
	{
		extent.flush();
		extent.close();
	}
	public static String takeSS() throws IOException, ParserConfigurationException, SAXException
	{
		String SSpath = getData("ReportPath") +"Execution" + timeStamp + "/" + "screenShut_" +getRandomNumber() + ".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(SSpath));
		return SSpath;
	}
	public static int getRandomNumber(){
		Random rand = new Random();
		return rand.nextInt(9999999)+ 1 ;

	}
}
