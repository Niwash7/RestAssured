package Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Authentication {
@Test
public void preemptive_auth() {
	
	given()
	.auth().preemptive().basic("admin", "root")
	.when()
	.get("http://localhost:8888")
	.then()
	.log().all();
	}

@Test
public void digestive_auth() {

	given()
	.auth().digest("admin", "root")
	.when()
	.get("http://localhost:8888")
	.then()
	.log().all();
	}
}
