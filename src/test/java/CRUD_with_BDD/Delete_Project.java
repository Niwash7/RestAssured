package CRUD_with_BDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Delete_Project {
@Test
public void delete_Project () {
	
	 when()
	.delete("http://localhost:8084/projects/TY_PROJ_1003")
	
	.then()
	.assertThat()
	.statusCode(204)
	.log().all();
	}
}
