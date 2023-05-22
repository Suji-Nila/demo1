package Collection;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post {
	@Test
	public void TC2() {
	RestAssured.baseURI="http://localhost:3000/";
	//To get the details in console
	Response Resp1=given()
			.contentType(ContentType.JSON)
	        .body("{\n"
			
			+ "      \"title\": \"title5\",\n"
			+ "      \"author\": \"dhivagar\"\n"
			+ "    }\n"
			+ "")
	.when()
	.post("/posts");
	
	//Response code of POST request
	assertEquals(Resp1.getStatusCode(),201);
	
    //Send the request and get the response
	Response Resp=given().get("/posts/5").then().extract().response();
	//Response is in Json Format
	//Change Response to String
	
	assertEquals(Resp.getStatusCode(),200);
	assertEquals(Resp.jsonPath().getString("id"),"5");
	//assertEquals(Resp.jsonPath().getString("id"),"1");
	assertEquals(Resp.jsonPath().getString("title"),"title5");

	given().get("/posts").then().log().all();
	
	
	
	
	
	
	
}


}



