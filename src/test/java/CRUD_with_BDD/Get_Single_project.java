package CRUD_with_BDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get_Single_project {
@Test
public void get_Single_project () {
	
	when()
	.get("http://localhost:8084/projects/TY_PROJ_004")
	
	.then()
	.assertThat()
	.statusCode(200)
	.log().all();
	}
}
