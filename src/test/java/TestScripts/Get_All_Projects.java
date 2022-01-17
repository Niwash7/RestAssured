package TestScripts;

import org.testng.annotations.Test;

import Generic_Utility.BaseApiClass;
import Generic_Utility.EndPoints;


import static io.restassured.RestAssured.*;

public class Get_All_Projects extends BaseApiClass {
@Test
public void getAll() {
	
	when()
	.get(EndPoints.GET_ALLPROJECTS)
	.then()
	.assertThat()
	.statusCode(200)
	.log().all();
	}
 }
