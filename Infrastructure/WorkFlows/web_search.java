package WorkFlows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Extensions.click;
import Extensions.update;
import Utilities.commonOps;

public class web_search extends commonOps {
         public static void go(String searchValue , String searchCategory) throws IOException, ParserConfigurationException, SAXException
         {
 	       update.text(ebayMain.searchBox, searchValue);
 	       update.drpoDownText(ebayMain.selectCategory, searchCategory);
 	       click.clickAndGo(ebayMain.searchButton);
 	       }

}