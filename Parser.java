
import java.io.File;
import java.util.Map;

public class Parser {
	
	public static void main(String[] args) {
		
	File input = new File ("4020a1-datasets.txt");
	DatasetPaser myPaser= new DatasetPaser(input);
	
	APIConnector api = new APIConnector(myPaser.getArticlesMap());
	api.getXML();
	
	Map<String, String> results = api.getIdMap();
	
	for (String title : results.keySet()) {
		String id = results.get(title);
		System.out.println("Article title: " + title);
		System.out.println("Article id: " + id);
		System.out.println("---");
	}
	
	}
}



