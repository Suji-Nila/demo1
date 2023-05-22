package APITesting.RESTAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class Question3 {
	@Test
	public void test_createUser() { 
		
	RestAssured.useRelaxedHTTPSValidation();

	JSONObject request = new JSONObject();

	request.put("name", "kajal");
	request.put("job", "Engineer");

	System.out.println(request.toJSONString()); 
	baseURI="https://reqres.in";

	given().

	header("Content-Type","application/json"). body (request. toJSONString()).

	when().

	post("/api/users"). then().

	statusCode(201). log().all();

	}
	
}
