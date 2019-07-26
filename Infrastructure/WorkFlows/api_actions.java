package WorkFlows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Extensions.RESTAPI;
import Utilities.commonOps;
import io.restassured.response.Response;

public class api_actions extends commonOps
{
	private static List<String> details = new ArrayList<String>();
	private static List<String> subjects = new ArrayList<String>();
	public static void postNewStudent() throws ParserConfigurationException, SAXException, IOException {
		details.add("eli");
		details.add("atiya");
		details.add("eliatiya770@gmail.com");
		details.add("Software Development");
		subjects.add("Math");
		subjects.add("english");
		subjects.add("grammer");
		RESTAPI.post(details, subjects);
	}
	public static Response getDetails() throws ParserConfigurationException, SAXException, IOException {
		return RESTAPI.get(getData("API_URL") + getData("API_Resource") + "/list");
	}
}
