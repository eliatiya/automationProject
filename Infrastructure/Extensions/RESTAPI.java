package Extensions;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.commonOps;
import io.restassured.response.Response;

public class RESTAPI extends commonOps {
	@SuppressWarnings("unchecked")
	public static void post(List<String> params,List<String> courseList) throws ParserConfigurationException, SAXException, IOException {
		try {
		requestParams.put("firstName", params.get(0));
		requestParams.put("lastName", params.get(1));
		requestParams.put("email", params.get(2));
		requestParams.put("programme", params.get(3));
		requestParams.put("courses", courseList);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		httpRequest.post(getData("API_Resource"));
		test.log(LogStatus.PASS," Post succeeded");
		}catch (Exception e) {
			test.log(LogStatus.FAIL,"post has Failed , see details: " + e);
			fail("post has Failed , see details: " + e);
		}
	}
	public static Response get(String url) 
	{
		resp = httpRequest.get(url);
		return resp ; 
	}

}
