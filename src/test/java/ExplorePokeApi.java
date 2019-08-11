import static io.restassured.RestAssured.given;

import org.approvaltests.Approvals;
import org.junit.Test;

import io.restassured.response.Response;

public class ExplorePokeApi {
	
	//Docs: https://pokeapi.co/docs/v2.html

		@Test
		public void testPokemon() throws Exception {
			 Response response = given().get("https://pokeapi.co/api/v2/pokemon/ditto/");
			 Approvals.verify(response.body().prettyPrint());
		}
		
		
		
		
		
		

	}
	
	