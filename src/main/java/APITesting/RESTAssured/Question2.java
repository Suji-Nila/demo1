package APITesting.RESTAssured;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.matcher.RestAssuredMatchers.*; 
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;


public class Question2 {
@Test
public void test_getUser() {
RestAssured.useRelaxedHTTPSValidation();
baseURI ="https://reqres.in";
given().
get("/api/users?page=2").
then().
statusCode(200).
body("data[1].id",equalTo(8)).
body("data[4].first_name", equalTo("George")).
body("data.first_name",hasItems("George","Rachel"));
	}
}


