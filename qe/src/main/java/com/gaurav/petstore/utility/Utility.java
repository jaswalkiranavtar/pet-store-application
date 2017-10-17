package com.gaurav.petstore.utility;

import static io.restassured.RestAssured.given;

import java.util.Base64;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class Utility {
	
	public static RequestSpecification getRequestSpecification(String baseUrl, String accessToken, String logAll) {
        RequestSpecification spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(baseUrl)
                .build();
        if (accessToken !=null && !accessToken.isEmpty()) {
            spec.header("Authorization", accessToken);
            //spec.header("Content-Type", "application/json");
        }
        if (logAll.toUpperCase().equals("Y")){
            spec.log().all();

        }
        else {
            spec.log().ifValidationFails();
        }

        return spec;
    }

	public static String getAuthorizationToken(String clientID, String clientSecret, String oauth2URL, String userName, String password) {
        
		String creds = clientID + ":" + clientSecret;
		String encodedAuth = Base64.getEncoder().encodeToString(creds.getBytes());
        
		String tokenUrl = oauth2URL + "?grant_type=password&username=" + userName 
        		+ "&password=" + password + "&scope=abcde" + "&client_id=" + clientID;
		
		String response = given()
							.log()
							.all()
						.when()
							.header(new Header("Authorization", "Basic " + encodedAuth))
							.post(tokenUrl)
							.asString();
		
		return new JsonPath(response).getString("access_token");
		
	}
}
