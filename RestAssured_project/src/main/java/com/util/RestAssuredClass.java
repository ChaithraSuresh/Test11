package com.util;

import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

public class RestAssuredClass {
	
	@Test
	public void firstRestMethod() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();
		//Response response = req.request(Method.GET, "/todos/1");
		Response response = RestAssured.given().when().get("/todos/1");
		System.out.println("response code =" + response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.getHeaders());
		
	}
	
	@Test
	public void secondRestMethod() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		given().when().get("/").then().log().body();
		given().queryParam("page", "3").when().get("/").then().log().body();
	}
	
	
	@Test
	public void thridRestMethod() {
		RestAssured.baseURI = "https://reqres.in/api/";
		given().queryParam("page", "1").when().get("/users").then().log().status();
		//given().queryParam("page", "3").when().get("/users").then().assertThat().statusCode(200);
		//given().queryParam("page", "3").when().get("/users").then().assertThat().statusCode(200).body("page", equalTo(1));
		given().queryParam("page", "1").when().get("/users").then().assertThat().statusCode(200).body("page", equalTo(1)).
		body("data.first_name", hasItems("George", "Tracey")).body("total", greaterThan(10));
		
	}
	
	@Ignore
	public void PostingdataRestMethod() {
		RestAssured.baseURI = "https://reqres.in/api/";
		given().when().get("/users/23").then().assertThat().statusCode(404);
		/*String bodydata = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";*/
		//given().body(bodydata).when().log().all().post("/users").then().assertThat().statusCode(201).log().body();
		
		//*Instead of above method we can use Hashmap
		Map <String, String> bodyData = new HashMap<String, String>();
		bodyData.put("email", "eve.holt@reqres.in");
		bodyData.put("password", "pistol");
		given().contentType("application/json").body(bodyData).when().post("register/").then().assertThat().statusCode(200).body("id", equalTo(4)).
		and().assertThat().body(containsString("QpwL5tke4Pnpja7X4"));
		given().contentType("application/json").body(bodyData).when().post("register/").getHeaders();
		//given().getClass().	
	}
	
	@Test
	public void PutmethodRestMethod() {
		RestAssured.baseURI = "https://reqres.in/api/";
		Map <String, String> putData = new HashMap<String, String>();
		putData.put("name", "morpheus");
		putData.put("job", "zion resident");
		ValidatableResponse responsep = given().contentType("application/json").body(putData).when().log().body().put("/users/2").then().log().body();
		responsep.assertThat().statusCode(200);
		given().put("/users/2").getHeaders();
		given().response().given().expect().body(containsString("zion resident"));
		
	
	}
	
	@Test
	public void DeeletedataRestMethod() {
		RestAssured.baseURI = "https://reqres.in/api/";
		given().delete("/users/2").getHeaders();
		given().delete("/users/2").then().assertThat().statusCode(204);
		

	}
	
	
	@Test
	public void SerializationMethod() {
		RestAssured.baseURI = "https://reqres.in/api/";
		RestPojo rp = new RestPojo("eve.holt@reqres.in", "pistol");
		//if we dont use constructors then object.setmethod should be called for both variables
		//rp.setName()
		//rp.setJob()
		//System.out.println(rp.toString());
		given().contentType("application/json").body(rp).when().post("register/").then().assertThat().statusCode(200).body("id", equalTo(4)).
		and().assertThat().body(containsString("QpwL5tke4Pnpja7X4"));
		
}
	
	@Test
	public void SerializationMethod2() {
		RestAssured.baseURI = "https://reqres.in/api/";
		RestPojo rs = new RestPojo("eve.holt@reqres.in", "cityslicka");
		given().contentType("application/json").body(rs).when().post("login/").then().assertThat().statusCode(200).
		and().assertThat().body(containsString("QpwL5tke4Pnpja7X4"));
		
}
	
	@Test
	public void PostmethodApiChaining() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/store/";
		String bodydata = "{\r\n"
				+ "  \"id\": 2,\r\n"
				+ "  \"petId\": 2234,\r\n"
				+ "  \"quantity\": 1,\r\n"
				+ "  \"shipDate\": \"2022-04-20T11:44:32.037+0000\",\r\n"
				+ "  \"status\": \"placed\",\r\n"
				+ "  \"complete\": true\r\n"
				+ "}";
		given().contentType("application/json").body(bodydata).when().post("order/").then().assertThat().statusCode(200);
		Integer id = given().contentType("application/json").body(bodydata).when().post("order/").then().extract().jsonPath().get("id");
		System.out.println(id);
		given().when().get("order/"+id).then().log().body().and().assertThat().statusCode(200);
		
}
}
