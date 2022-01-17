package Generic_Utility;

import io.restassured.response.Response;

/**
 * 
 * @author Niwash
 *
 */
public class JsonUtility {

	// returns the data from response based on json pathParam
	public String getJsonValueData(Response response, String jsonPath) {
	
		String jsonData = response.jsonPath().get(jsonPath);
		return jsonData;	
	}
}