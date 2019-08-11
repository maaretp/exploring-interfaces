import static io.restassured.RestAssured.given;

import org.approvaltests.Approvals;
import org.junit.Test;

import io.restassured.response.Response;
import static org.junit.Assert.*;

public class ExploreSwApi {

		@Test
		public void testSwapi() throws Exception {
			 Response response = given().get("https://swapi.co/api/people/1");
			 Approvals.verify(response.body().prettyPrint());
		}
		
		
		@Test
		public void testSwapiDelete()  {
			 Response response = given().delete("https://swapi.co/api/people/1");
			 assertEquals(301, response.getStatusCode());
		}
		

	}
	
	