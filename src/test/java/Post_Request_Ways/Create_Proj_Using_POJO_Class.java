package Post_Request_Ways;

import org.testng.annotations.Test;

import POJO_Class.Project_Library;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Create_Proj_Using_POJO_Class {
@Test
public void create_Proj_Using_POJO_Class() {
	
	baseURI = "http://localhost";
	port = 8084;
	
	//prepare request body
	Project_Library plib = new Project_Library("Sweetmom","Life","onGoing",5);
	
	given()
	.contentType(ContentType.JSON)
	.body(plib)
	
	.when()
	.post("/addProject")
	
	.then()
	.assertThat()
	.statusCode(201)
	.log().all();

	}
}
