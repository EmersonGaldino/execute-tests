package com.api.user;

import com.api.ApiTestBase;
import com.api.model.UserErrorResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag( "Negative")
public class NegativeUserApiTest extends ApiTestBase {
    public NegativeUserApiTest() {
        super("emilys", "emilyspass");
    }

    @Test
    public void testGetUserByIdNotFoundExist() {
        //Arrange
        int userId = 99999;
        Response response = given()
                .pathParam("id", userId)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(404)
                .extract()
                .response();
        //ACT
        UserErrorResponse result = response.as(UserErrorResponse.class);

        //Assert
        assertEquals("User with id '99999' not found", result.getMessage());

    }
}
