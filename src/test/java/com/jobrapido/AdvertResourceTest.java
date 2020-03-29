package com.jobrapido;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class AdvertResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/advert/hello")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

    @Test
    public void testAdvertEndpoint() {
        given()
          .when().get("/advert/all")
          .then()
            .statusCode(200)
            .body(is(not(nullValue())));
    }

}