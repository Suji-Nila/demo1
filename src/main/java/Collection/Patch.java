package Collection;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Patch {
	public static String RandomTitle=GetRandomString();
	@Test
	public void S1() {
		//Base URL
	RestAssured.baseURI="http://localhost:3000";
	given().get("/posts/2").then().log().all();
	Response Resp1=given().contentType(ContentType.JSON)
			.body("{\n"
					+ "    \n"
					+ "      \"title\": \""+RandomTitle+"\"\n"
					+ "\n"
					+ "    }" )
			.when()
			.patch("/posts/2");
			//Response code of POST request
			assertEquals(Resp1.statusCode(),200);
			assertEquals(Resp1.jsonPath().getString("title"),RandomTitle);
	}
		//code to generate random string for all the request
      public static String GetRandomString() {
		
		Random random=new Random();
		String NewTitle="New_"+random.nextInt();
		return NewTitle;
	}
			
		   

}
