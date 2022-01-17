package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Basic_Auth {
@Test
public void basic_Auth() {
	
	given()
	.auth().basic("rmgyantra", "rmgy@9999")
	.when()
	.get("http://localhost:8084")
	.then()
	.assertThat()
	.statusCode(200)
	.log().all();
	}
}
