package Parameters_Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Parameter_Using_Git_Api {
@Test
public void parameters () {

	given()
	.pathParam("username", "Nivu18")
	.queryParam("sort", "created")
	.when()
	.get("https://api.github.com/users/{username}/repos")
	.then()
	.assertThat()
	.statusCode(200)
	.log().all();
	}
}
