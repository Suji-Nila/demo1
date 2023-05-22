package APITesting.RESTAssured;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


import io.restassured.RestAssured;


import org.testng.annotations.Test;

public class Question6 {
	@Test

	public void test_deleteUser() { 
		RestAssured.useRelaxedHTTPSValidation();

	baseURI="https://reqres.in";

	given().
	delete("/api/users/2").

	then().

	statusCode (204).

	log().all();

	}}




