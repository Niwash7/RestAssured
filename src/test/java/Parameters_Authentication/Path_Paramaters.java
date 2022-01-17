package Parameters_Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Path_Paramaters {
@Test
public void pathParameters () {
	
	given()
	.pathParam("projectId", "TY_PROJ_603")
	.when()
	.delete("http://localhost:8084/projects/{projectId}")
	.then()
	.assertThat()
	.statusCode(204)
	.log().all();
	}
}
