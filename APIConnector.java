import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class APIConnector {
	
	// Map of article title to article URL.
	private Map<String, String> articlesMap;
	
	// We will be storing the Titles to ID map in this data structure.
	private Map<String, String> IdMap = new HashMap<>();
	
	public APIConnector(Map<String, String> articlesMap) {
		this.articlesMap = articlesMap;
	}
	
	public void getXML() {
		
		// Loop through ArrayList containing URLs.
		for (String title : articlesMap.keySet()) {
			
			// Gets the URL string from our HashMap data structure.
			String url = articlesMap.get(title);
			
			try {
				// Create a new URL object with the URL string, and start a connection.
				URL obj = new URL(url);
				InputStream in = obj.openStream();
				
				// XMLReader instantiation according to SAX documentation.
				SAXParserFactory parserFactory = SAXParserFactory.newInstance();
				SAXParser parser = parserFactory.newSAXParser();
				XMLReader reader = parser.getXMLReader();
				
				// Tell XML reader to use our article parser handler.
				ArticleParser handler = new ArticleParser();
				reader.setContentHandler(handler);
				
				// XML Reader starts to parse.
				InputSource inSource = new InputSource(in);
				reader.parse(inSource);
				
				// Get the article ID from XML Reader.
				String id = handler.getId();
				
				// Put the article title and article id in the map.
				IdMap.put(title, id);
				
			} catch (MalformedURLException e) {
				System.out.println("Error at URL");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error at connecting to Server");
				e.printStackTrace();
			} catch (SAXException e) {
				System.out.println("Error at parsing XML");
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				System.out.println("Error at parser config");
				e.printStackTrace();
			}
			
		}
		
	}
	
	public Map<String, String> getIdMap() {
		return this.IdMap;
	}
	
}
