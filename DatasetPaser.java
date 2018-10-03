import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

//This class parses the dataset and generate urls.
public class DatasetPaser {
	
	ArrayList<String> ResultUrl = new ArrayList<>();
		
	Map<String, String> articles = new HashMap<>();
	 
	public DatasetPaser(File f){
		File inputFile= f;
		
		try {
		//initialize 
		DocumentBuilderFactory  dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();
		NodeList TitleList = doc.getElementsByTagName("ArticleTitle");
		
		//Loop through all titles
		for (int i=0 ; i<10;i++) {
			
			String title = TitleList.item(i).getTextContent();
			String url = CreateUrl(TitleList.item(i).getTextContent());
			
			// This maps the article title to its corresponding URL.
			articles.put(title, url);
		}

		} catch (Exception e){
			e.printStackTrace();
		}	
		
		
		
		
		
		
		
	}
	
	//return all urls as an arraylist 
	public ArrayList getResultUrls(){
		return ResultUrl;
	}
	
	//return article title and its corresponding URL as map
	public Map getArticlesMap() {
		return this.articles;
	}
	 
	
	
	
	//create a single url 
	String CreateUrl (String t){
			String Title = t;

			
			//Do url encoding on "'s"
			String result = Title.replace("'s", "%27s");
			//Get rid of other special characters
			result = result.replaceAll("[+.'^:,?]","");
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
