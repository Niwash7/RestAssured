package Responses_Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import Generic_Utility.BaseApiClass;
import Generic_Utility.EndPoints;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Hamcrests extends BaseApiClass {
@Test
public void testing() {
	
	when()
	.get(EndPoints.GET_ALLPROJECTS)
	.then()
	.assertThat()
	.statusCode(200)
	.assertThat().time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS)
	.assertThat().body("[0].projectName", Matchers.equalTo("Thameez"))
	.log().all();
	}
}
