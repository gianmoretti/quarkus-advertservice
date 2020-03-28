package com.jobrapido;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class AdvertResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

    @Test
    public void testAdvertEndpoint() {
        String advertId = "FakeAdvert";
        given()
          .pathParam("name", advertId)
          .when().get("/hello/advert/{name}")
          .then()
            .statusCode(200)
            .body(is("Advert: " + advertId));
    }

}