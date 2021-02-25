package com.libraryCT.RestAssured_API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;


public class SpartansTest {

    String url = "http://3.91.226.64:8000/api/spartans/";
    String url2 ="https://openlibrary.org/api/books";
    String url3 ="http://library2.cybertekschool.com/api/books";
    @Test
    public void viewAll() {
       Response response = RestAssured.get(url2);
        System.out.println(response.getHeaders());
        System.out.println(response.statusCode());
        System.out.println(response.body().prettyPrint());

}
    @Test
    public void viewAllWithAuth() {
       // Response response = RestAssured.get(url);
        Response response= RestAssured.given().auth().basic("admin", "admin").accept(ContentType.JSON).when().get(url);
        System.out.println(response.statusCode());
        System.out.println(response.body().prettyPrint());

    }
    @Test
    public void viewWithStaticImport(){
        given().accept(ContentType.JSON).when().get(url2).then().statusCode(200)
                .and().contentType("application/json");
    }
    @Test
    public void viewWithStaticImport2(){
        given().accept(ContentType.JSON).when().auth().basic("admin", "admin").get(url).then().statusCode(200)
                .and().contentType("application/json");

    }

    @Test
    public void test1(){
        given().accept(ContentType.JSON).when().get(url3).then().statusCode(200)
                .and().contentType("application/json");

    }

}
