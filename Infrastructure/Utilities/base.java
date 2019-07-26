package Utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import PageObjects.MainPage;
import PageObjects.ResultsPage;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class base {

	public static WebDriver driver;
	public static MainPage ebayMain;
	public static ResultsPage ebayResult;
	public static Screen screen ;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static RequestSpecification httpRequest;
	public static JSONObject requestParams = new JSONObject();
	public static Response resp;


	public static String timeStamp = new SimpleDateFormat("yyyy-mm-dd_HH-mm-ss").format(Calendar.getInstance().getTime()); 
}
