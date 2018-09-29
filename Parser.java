

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;



public class Parser {
	public static void main(String[] args) {
	File input = new File ("4020a1-datasets.txt");
	DatasetPaser myPaser= new DatasetPaser(input);
	
		 
	}
	
	
}



