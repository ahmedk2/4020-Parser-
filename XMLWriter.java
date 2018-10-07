import java.io.File;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriter {

	public static void main(String[] args) {
		final String xmlFilePath = 
				"C:\\Users\\Khalid_Northside97\\Desktop\\groupID2_result.xml";
		try {
			            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			            Document document = documentBuilder.newDocument();
			            
			            APIConnector api = new APIConnector(myPaser.getArticlesMap());
			        	api.getXML();
			        	
			        	Map<String, String> results = api.getIdMap();
			        	
			            // PubmedArticleSet element
			            Element PubmedArticleSet = document.createElement("PubmedArticleSet");
			            document.appendChild(PubmedArticleSet);

			            // PubmedArticle element
			            Element PubmedArticle = document.createElement("PubmedArticle");
			            PubmedArticleSet.appendChild(PubmedArticle);
			            
			            
		
			            // PMID element
			            Element PMID = document.createElement("PMID");
			            PubmedArticleSet.appendChild(PMID);
	
			            // ArticleTitle element
			            Element ArticleTitle = document.createElement("ArticleTitle");
			            PubmedArticleSet.appendChild(ArticleTitle);
			
			            
			            // create the XML file
			            //transform the DOM Object to an XML File
			            TransformerFactory transformerFactory = TransformerFactory.newInstance();
			            Transformer transformer = transformerFactory.newTransformer();
			            DOMSource domSource = new DOMSource(document);
			            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
			
			            transformer.transform(domSource, streamResult);
			
			            System.out.println("Done creating XML File");
	
			        } catch (ParserConfigurationException pce) {
			            pce.printStackTrace();
			        } catch (TransformerException tfe) {
			            tfe.printStackTrace();
			        }
		}

	
	}


