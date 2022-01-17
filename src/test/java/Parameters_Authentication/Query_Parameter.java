package Parameters_Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Query_Parameter {
	@Test
	public void queryParameters () {
		
		given()
		.queryParam("page", "2")
		.when()
		.delete("http://reqres.in/api/users")
		.then()
		.log().all();
		
		}
}
