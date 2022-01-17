package Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Bearer_Token {
@Test
	public void bearer_Token() {
	
	given()
	.auth().oauth2("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")
	.when()
	.get("https://api.github.com/user/repos")
	.then()
	.assertThat()
	.statusCode(200)
	.log().all();
	}
}
