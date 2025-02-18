package com.api.products;

import com.api.ApiTestBase;
import com.api.model.Product;
import com.api.model.ProductResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class PositiveAuthProductsTest extends ApiTestBase {

    public PositiveAuthProductsTest() {
        super("emilys", "emilyspass");
    }

    @Test
    public void testProductsListNotEmpty() {
        String token = getAccessToken();
        Response response = given()
                .header("Content-Type", "application/json")
                .header( "Authorization", "Bearer " + token)
                .when()
                .get("/auth/products")
                .then()
                .statusCode(200)
                .extract()
                .response();

        ProductResponse products = response.body().as(ProductResponse.class);

        assertNotNull(products);
        assertNotNull(products.getProducts());
        assertFalse(products.getProducts().isEmpty(), "A lista de produtos não deve estar vazia");
    }
    @Test
    public void testProductById() {

        //ACT
        int productId = 1;
        String token = getAccessToken();
        Response response = given()
                .header("Content-Type", "application/json")
                .header( "Authorization", "Bearer " + token)
                .pathParam("id", productId)
                .when()
                .get("/auth/products/{id}")
                .then()
                .statusCode(200)
                .extract()
                .response();

        //ACT
        Product product = response.body().as(Product.class);

        //Assert
        assertEquals(productId, product.getId());
        assertEquals("RCH45Q1A", product.getSku());
        assertEquals("beauty", product.getCategory());
        assertEquals("Essence Mascara Lash Princess", product.getTitle());

    }
}
