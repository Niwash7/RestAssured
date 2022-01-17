package TestScripts;

import org.testng.annotations.Test;

import Generic_Utility.BaseApiClass;
import Generic_Utility.EndPoints;

import static io.restassured.RestAssured.*;

public class Get_Project extends BaseApiClass {
@Test
public void get() {
	
	given()
	.pathParam("projectId","TY_PROJ_802")
	.when()
	.get(EndPoints.GETSINGLE_PROJECT)
	
	.then()
	.assertThat()
	.statusCode(200)
	.log().all();
	}
}

