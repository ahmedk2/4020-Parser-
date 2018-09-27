

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
		 
		try { 
		//initialize 
		File inputFile= new File ("4020a1-datasets.txt");
		DocumentBuilderFactory  dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();
		
		//Store all titles in a Nodelist 
		NodeList TitleList = doc.getElementsByTagName("ArticleTitle");
		
		//Loop through all Titles
		for (int i=0 ; i<5;i++)
		{
			
			
			String Title = TitleList.item(i).getTextContent();
			//Get rid of special characters
			String result = Title.replaceAll("[+.'^:,?]","");
			//Separate each word, put them into an array
			String[] Splited = result.split("\\s+");
			String Url = "https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=pubmed&term=";
			
			//generate urls
			for (int a=0; a<Splited.length;a++){
			if (a==Splited.length-1){
					Url += Splited[a];
					Url += "&field=title";
				}else{
					Url+= Splited[a];
					Url += "+";
				}
			
			
			}
			
			System.out.println(Url);
		}
		
		
		
		
		
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
	 }
	
	
	
}
