package Collection;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Delete {
	public static String title=GetRandomString();
	@Test
	public void TC3() {
		RestAssured.baseURI="http://localhost:3000/";
		given().get("/posts/2").then().log().all();
		//To get the details in console
		Response Resp1=given()
				.contentType(ContentType.JSON)
		        .body("{\n"
		    			+ "      \"title\": \"title9\",\n"
		    			+ "      \"author\": \"Sam\"\n"
		    			+ "    }\n" 
		    			+ "")
		.when()
		.post("/posts");
		//Display
		
		String NewlyAddedPostId=Resp1.jsonPath().getString("id");
		//Deletion
				Response RespOfDeletionReq=given().delete("/posts/" +NewlyAddedPostId+"");
				given().delete("/posts/1" );
				given().delete("/posts/10" );given().delete("/posts/11" );given().delete("/posts/12" );
		//verify if the above created  data is deleted
				assertEquals(Resp1.getStatusCode(),201);
				given().get("/posts").then().log().all();
		assertEquals(RespOfDeletionReq.statusCode(),200);
		System.out.println("The status code after deletion is asexpected:"+RespOfDeletionReq.statusCode());
		
}
//code to generate random string for all the requests
	public static String GetRandomString() {
		
		Random random=new Random();
		String NewTitle="New_"+random   .nextInt();
		return NewTitle;
	}
	
	

}
