package com.api;

import com.api.model.LoginResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {
    private static String AccessToken;
    public ApiTestBase(String username, String password) {
        if (AccessToken == null) { // Gera o token apenas se ele ainda não foi gerado
            AccessToken = GetAccessToken(username, password);
        }
    }
    public String getAccessToken() {
        return AccessToken;
    }

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://dummyjson.com";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public  static String GetAccessToken(String username, String password){
        String loginBody = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .response();

        LoginResponse loginResponse = response.as(LoginResponse.class);

        return loginResponse.getAccessToken();
    }
}
