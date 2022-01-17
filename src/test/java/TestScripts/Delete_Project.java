package TestScripts;

import org.testng.annotations.Test;
import Generic_Utility.BaseApiClass;
import Generic_Utility.EndPoints;

import static io.restassured.RestAssured.*;

public class Delete_Project extends BaseApiClass {
@Test
public void delete() {
	
	given()
	.pathParam("projectId", "TY_PROJ_1602")
	.when()
	.delete(EndPoints.DELETE_PROJECT)
	.then()
	.assertThat()
	.statusCode(204)
	.log().all();
	}
}
