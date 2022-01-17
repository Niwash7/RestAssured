package Request_Chaining;

import org.testng.annotations.Test;
import POJO_Class.Project_Library;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

/**
 * 
 * @author Niwash
 *
 */

public class Post_Delete {
@Test
public void postDelete() {
	
	// post and delete
	
	Project_Library plib = new Project_Library("Niwash", "HumptyDumpty", "created", 13);
	
	Response response = given()
	.contentType(ContentType.JSON)
	.body(plib)
	
	.when()
	.post("http://localhost:8084/addProject");
	
	String proID = response.jsonPath().get("projectId");
	
	given()
	.pathParam("pId", proID)
	.when()
	.delete("http://localhost:8084/projects/{pId}")
	
	.then().assertThat()
	.statusCode(204)
	.log().all();
	}
}
