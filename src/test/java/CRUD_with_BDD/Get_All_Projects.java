package CRUD_with_BDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get_All_Projects {
@Test
public void get_All_Projects () {
	
	when()
	.get("http://localhost:8084/projects")
	
	.then()
	.assertThat()
	.statusCode(200)
	.log().all();
	}
}
