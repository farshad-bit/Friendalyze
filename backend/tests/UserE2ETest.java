// backend/tests/UserE2ETest.java

package com.example.friendalyze;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) // Run the actual server
public class UserE2ETest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080; // Make sure this matches your actual running port
    }

    @Test
    public void testCreateUser_Success() {
        String requestBody = "{ \"username\": \"e2eUser\", \"email\": \"e2e@example.com\" }";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
            .post("/users")
            .then()
            .statusCode(201) // HTTP 201 Created
            .body("username", equalTo("e2eUser"))
            .body("email", equalTo("e2e@example.com"));
    }

    @Test
    public void testGetAllUsers_NotEmpty() {
        given()
            .when()
            .get("/users")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("size()", greaterThan(0)); // Expect at least 1 user in DB
    }
}
