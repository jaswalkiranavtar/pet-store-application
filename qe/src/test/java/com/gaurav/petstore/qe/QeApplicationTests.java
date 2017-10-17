package com.gaurav.petstore.qe;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gaurav.petstore.utility.Utility;

import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class QeApplicationTests {
	
	private static RequestSpecification userSpec;
	private static RequestSpecification adminSpec;
	
	
	@Before
	public void setUp() throws Exception {
		
		//String appBaseUri = "http://petstore-ui.mybluemix.net";
		String appBaseUri = "http://localhost:8080";
		
		String userAccessToken=Utility.getAuthorizationToken("petstore", "petstoresecret", "http://petstore-auth-server.mybluemix.net/uaa/oauth/token", "user", "user");
		String adminAccessToken=Utility.getAuthorizationToken("petstore", "petstoresecret", "http://petstore-auth-server.mybluemix.net/uaa/oauth/token", "admin", "admin");
	  
		userSpec = Utility.getRequestSpecification(appBaseUri, userAccessToken, "Y");
		adminSpec = Utility.getRequestSpecification(appBaseUri, adminAccessToken, "Y");
	}
	
	@Test
	public void testGetPetsByUser() {
        given().
        	spec(userSpec).
        when().
        	get("api/v1/data/list-all-pets").
        then().
        	statusCode(200);
	}
	
	@Test
	public void testCreatePetByUser() {
        given().
        	spec(userSpec).
        	body("{\"name\":\"Gaurav\"}").
        when().
        	post("api/v1/data/create-a-pet").
        then().
        	statusCode(403);
	}
	
	@Test
	public void testCreatePetByAdmin() {
        given().
        	spec(adminSpec).
        	body("{\"name\":\"Gaurav\"}").
        when().
        	post("api/v1/data/create-a-pet").
        then().
        	statusCode(200).
        	body(containsString("id"));
	}

}
