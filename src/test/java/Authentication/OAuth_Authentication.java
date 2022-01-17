package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth_Authentication {
@Test
public void OAuth2() {

	Response response = given()
	.formParam("client_id", "NiwashNivu")
	.formParam("client_secret", "cca410f44c6501aacd11c52257d53c9f")
	.formParam("grant_type", "client_credentials")
	.formParam("redirected_uri", "https://example.com")
	
	.when()
	.post("http://coop.apps.symfonycasts.com/token");
	String token = response.jsonPath().get("access_token");
	System.out.println(token);
	
	given()
	.auth().oauth2(token)
	.pathParam("USER_ID", 2687)
	.when()
	
//	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
//	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/toiletseat-down")
	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
//	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
//	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
	
	.then()
	.log().all();
	
	}
}
