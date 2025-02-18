package com.api.user;

import com.api.ApiTestBase;
import com.api.model.User;
import com.api.model.UserResponse;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Tag("Positive")
public class PostiveUserApiTest extends ApiTestBase {
    public PostiveUserApiTest() {
        super("emilys", "emilyspass");
    }
    @Test
    @Description("Testando a bsuca de usaurios")
    public void testGetUserById() {
        //Arrange
        int userId = 1;
        Response response = given()
                .pathParam("id", userId)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(200)
                .extract()
                .response();
        //ACT
        User user = response.as(User.class);

        //Assert
        assertEquals(userId, user.getId());
        assertEquals("Emily", user.getFirstName());
        assertEquals("emilys", user.getUsername());
        assertEquals("emily.johnson@x.dummyjson.com", user.getEmail());
    }

    @Test
    public void testUsersListNotEmpty() {
        Response response = given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .extract()
                .response();

        UserResponse users = response.body().as(UserResponse.class);

        assertNotNull(users);
        assertNotNull(users.getUsers());
        assertFalse(users.getUsers().isEmpty(), "A lista de usuários não deve estar vazia");
    }

    @Test
    public void testUsersCountMatchesTotal() {
        Response response = given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .extract()
                .response();

        UserResponse users = response.body().as(UserResponse.class);

        assertEquals(30, users.getUsers().size(), "A quantidade de usuários deve ser igual ao campo 'total'");
    }

    @Test
    public void testFirstUserHasValidData() {
        Response response = given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .extract()
                .response();

        UserResponse users = response.body().as(UserResponse.class);

        assertFalse(users.getUsers().isEmpty(), "A lista de usuários não deve estar vazia");

        User firstUser = users.getUsers().get(0);

        assertNotNull(firstUser.getId(), "O ID do usuário não pode ser nulo");
        assertNotNull(firstUser.getFirstName(), "O primeiro nome do usuário não pode ser nulo");
        assertNotNull(firstUser.getLastName(), "O sobrenome do usuário não pode ser nulo");
        assertNotNull(firstUser.getEmail(), "O e-mail do usuário não pode ser nulo");
        assertNotNull(firstUser.getPhone(), "O telefone do usuário não pode ser nulo");
    }

    @Test
    public void testPagination() {
        int limit = 5;
        int skip = 10;

        Response response = given()
                .queryParam("limit", limit)
                .queryParam("skip", skip)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .extract()
                .response();

        UserResponse users = response.body().as(UserResponse.class);

        assertEquals(users.getLimit(), limit, "O valor do 'limit' deve corresponder ao enviado na requisição");
        assertEquals(users.getSkip(), skip, "O valor do 'skip' deve corresponder ao enviado na requisição");
        assertTrue(users.getUsers().size() <= limit, "O número de usuários retornado não pode ser maior que o limite solicitado");
    }

    @Test
    public void testUserExists() {
        Response response = given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .extract()
                .response();

        UserResponse users = response.body().as(UserResponse.class);

        boolean found = users.getUsers().stream()
                .anyMatch(user -> "Emily".equals(user.getFirstName()) && "Johnson".equals(user.getLastName()));

        assertTrue(found, "O usuário esperado (Emily Johnson) não foi encontrado na resposta");
    }


}
