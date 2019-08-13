import static io.restassured.RestAssured.given;

import org.approvaltests.Approvals;

import io.restassured.response.Response;
import junit.framework.TestCase;

public class ExploreZipApi extends TestCase {

		public void testZip() throws Exception {
			 Response response = given().get("https://api.zippopotam.us/JE/JE3");
			 Approvals.verify("status code: " + response.getStatusCode() 
			 			+ "\n" + "headers: \n"
			 			+ response.headers().toString()
		 				+ "\n" + "body: \n" 
		 				+ response.body().prettyPrint());
		}
		
		public void	testMaskedZip() throws Exception {
			Approvals.verify(getMaskedHeader());
		}
		
		
		
		 public String getMaskedHeader(){
		     Response response = given().get("http://api.zippopotam.us/us/20500"); 
			 String responseString = response.headers().toString();
			 
				 responseString = responseString.replaceAll("Date=.*", "#####DATE");
			     responseString = responseString.replaceAll("Set-Cookie=.*", "#####COOKIE");
			     responseString = responseString.replaceAll("CF-RAY=.*", "#####CF-RAY");
		
	
		     return responseString;
		    }

	}
	
	