package com.api.auth;

import com.api.ApiTestBase;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;


import java.util.Base64;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PositiveAuthApiTest extends ApiTestBase {
    private static String AccessToken;

    public PositiveAuthApiTest() {
       super("emilys", "emilyspass");
    }

    @Test()
    public void positiveTestLogin() {
        String accessToken = getAccessToken();

        assertNotNull(accessToken);
        assertTrue(accessToken.split("\\.").length == 3);
    }
    @Test
    public void testTokenExpiration() throws JsonProcessingException {
        String accessToken = getAccessToken();

        String[] parts = accessToken.split("\\.");
        String payload = new String(Base64.getUrlDecoder().decode(parts[1]));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> claims = objectMapper.readValue(payload, Map.class);

        long expirationTime = ((Integer) claims.get("exp")).longValue();
        long currentTime = System.currentTimeMillis() / 1000;

        assertTrue(expirationTime > currentTime);
    }

}
