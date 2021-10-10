package org.example.api.store;

import com.google.gson.JsonArray;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.example.model.Invent;
import org.example.model.Pet;
import org.example.model.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class StoreApiTest {
    @BeforeClass
    public void prepare() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my.properties"));
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .addHeader("api_key", System.getProperty("api.key"))
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        RestAssured.filters(new ResponseLoggingFilter());
    }
    @Test
    public void placeOrderTest() {
        Response resp = new Response(); // создаём экземпляр POJO объекта Pet
        int id = new Random().nextInt(10);
        resp.setId(id);
        resp.setPetId(id);
        resp.setQuantity(1);
        resp.setComplete(true);
        resp.setStatus("placed");
        given()
                .body(resp)
                .when()
                .post("store/order/")
                .then()
                .statusCode(200);
        Response actual =
                given()
                        .pathParam("id", id)
                        .when()
                        .get("/store/order/{id}")
                        .then()
                        .statusCode(200)
                        .extract().body()
                        .as(Response.class);
    }
//
    @Test
    public void deleteOrderTest() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my.properties"));
        given()
                .pathParam("id", System.getProperty("id"))
                .when()
                .delete("store/order/{id}")
                .then()
                .statusCode(200);
        given()
                .pathParam("id", System.getProperty("id"))
                .when()
                .get("store/order/{id}")
                .then()
                .statusCode(404);
    }
    @Test
    public void inventTest() throws IOException {
       Map a =  given()
                .when()
                .get("store/inventory")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(Map.class);
       Assert.assertTrue(a.containsKey("sold"));
    }
}
