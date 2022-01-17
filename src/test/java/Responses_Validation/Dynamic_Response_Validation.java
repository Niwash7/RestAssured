package Responses_Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class Dynamic_Response_Validation {
@Test
public void dynamicValidation () {
	
	String expProjName = "Niwash";
	Response resp = when()
			.get("http://localhost:8084/projects");
	List<String> projName = resp.jsonPath().get("projectName");
	
	boolean flag = false;
	for(String ele : projName) {
		if (ele.equals(expProjName)) {
			flag = true;
			break ;
		}
	}
	resp.then()
	.assertThat().statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
	
	Assert.assertEquals(flag, true);
	}
}
