import static io.restassured.RestAssured.given;

import org.approvaltests.Approvals;

import io.restassured.response.Response;
import junit.framework.TestCase;

public class ExploreSwApi extends TestCase {

		public void testSwapi() throws Exception {
			 Response response = given().get("https://swapi.co/api/people/1");
			 Approvals.verify(response.body().prettyPrint());
		}
		
		
		
		

	}
	
	