package Responses_Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Static_Response_Validation {
@Test
public void getAllProjectsAndverify() {
	
	String expProjName = "Niwash";
	Response resp = when()
		.get("http://localhost:8084/projects");
	String actProjName = resp.jsonPath().get("[0].projectName");
	
	resp.then()
	.assertThat().statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
	
	Assert.assertEquals(expProjName, actProjName);
			
	}
}
