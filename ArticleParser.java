import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class ArticleParser extends DefaultHandler {
	
	boolean idFlag = false;
	
	String id = null;
	
	public ArticleParser() {
		super();
	}
	
	public void endDocument() {
	}
	
	public void startElement(String uri, String name, String qName, Attributes atts) {
		if(qName.equalsIgnoreCase("Id")) {
			idFlag = true;
		}
	}
	
	public void characters(char ch[], int start, int length) {		
		
		if (idFlag) {
			this.id = new String(ch, start, length);			
			idFlag = false;
		}
	}
	
	public String getId() {
		return this.id;
	}
	
}
