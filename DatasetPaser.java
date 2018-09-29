
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;



public class DatasetPaser {
	ArrayList<String> ResultUrl = new ArrayList<>();
	 
	 
	public DatasetPaser(File f){
		File inputFile= f;
		
		try { 
		//initialize 
		DocumentBuilderFactory  dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();
		NodeList TitleList = doc.getElementsByTagName("ArticleTitle");
		
		for (int i=0 ; i<5;i++)
		{
			ResultUrl.add(CreateUrl(TitleList.item(i).getTextContent()));
		}
	
		
		
		
		
		} catch (Exception e){
			e.printStackTrace();
		}	
		
		
		
		//Store all titles in a Nodelist 
		
		
		
	}
	
	public ArrayList getResultUrls(){
		return ResultUrl;
	}
	 
	
	
	
	
	String CreateUrl (String t){
			String Title = t;

			
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
			return Url;
	 }
	 
	

}
