package Collection;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import  static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get {
	@Test
	public void TC1() {
		//BaseURL
		RestAssured.baseURI="http://localhost:3000/";
		//To get the details in console
		given().get("/posts/2").then().log().all();
		
	    //Send the request and get the response
		Response Resp=given().get("/posts/2").then().statusCode(200).extract().response();
		//Response is in Json Format
		//Change Response to String
		
		assertEquals(Resp.getStatusCode(),200);
		assertEquals(Resp.jsonPath().getString("id"),"2");
		//assertEquals(Resp.jsonPath().getString("id"),"1");
		assertEquals(Resp.jsonPath().getString("title"),"title2");
		
		
		
		
		
		
		
	}


}
