import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test01_GET {
	
	@Test
	void test_01() {
		
	//	Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println("==============================================================");
		System.out.println(response.getBody().asString());
		System.out.println("==============================================================");
		System.out.println(response.asPrettyString());
		System.out.println("==============================================================");
		System.out.println(response.getStatusLine());
		System.out.println("==============================================================");
		System.out.println(response.getHeader("content-type"));
		System.out.println("==============================================================");
		System.out.println(response.getTime());
	
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	
	
	@Test
	void test_02() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[1]", equalTo(8))
			.log()
			.all();
	
	
	}
	
	
}
