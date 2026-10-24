import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {
	
	@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		
		given()
			.get("/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data[4].first_name", equalTo("George"))
			.body("data.first_name", hasItems("Michael","Lindsay","Tobias","Byron"));
		
	}
	
	
	@Test
	public void testPost() {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("Name", "Kunal");
//		map.put("Job", "QA");
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		request.put("Name", "Kunal");
		request.put("Job", "QA");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("x-api-key", "reqr...d2b5").
			header("Content-Type", "application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201);
	}
	
	 
	  
	
}











