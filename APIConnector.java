import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class APIConnector {

	
	private ArrayList<String> urlList;
	
	public APIConnector(ArrayList<String> urlList) {
		this.urlList = urlList;
	}
	
	public void getXML() {
		
		// Loop through ArrayList containing URLs.
		for (String url : urlList) {
			
			try {
				// Create a new URL object with the URL string, and start a connection.
				URL obj = new URL(url);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				
				// Check HTTP response status.
				int responseCode = con.getResponseCode();
				System.out.println("Response: " + responseCode);
				
				// Read input stream from connection.
				InputStreamReader inputStream = new InputStreamReader(con.getInputStream());
				BufferedReader in = new BufferedReader(inputStream);
				
				String inputLine;
				StringBuilder response = new StringBuilder();
				while((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				System.out.println(response.toString());
				
			} catch (MalformedURLException e) {
				System.out.println("Error at URL");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error at connecting to Server");
				e.printStackTrace();
			}
			
		}
		
	}
	
}
