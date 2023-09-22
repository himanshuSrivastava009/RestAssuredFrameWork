package com.qa.Restclient;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestClient {

    static RequestSpecBuilder specBuilder;
    public static final String baseURI = "https://gorest.co.in";
    public String token = "8c0ed7439132a505f242d06cde1332c94be0be49d2352e8f250292f256b1d3ab";

     {
        specBuilder = new RequestSpecBuilder();
    }

    public void addAuthorization() {
        specBuilder.addHeader("Authorization", "Bearer " + token);
    }

    public RequestSpecification createSpecReuestSpec() {

        specBuilder.setBaseUri(baseURI);
        addAuthorization();
        return specBuilder.build();
    }

    public RequestSpecification createSpecReuestSpec(Map<String, String> header) {

        specBuilder.setBaseUri(baseURI);
        addAuthorization();
        specBuilder.addHeaders(header);
        return specBuilder.build();
    }

    public RequestSpecification createSpecReuestSpec(Map<String, String> header, Map<String, String> queryParam) {

        specBuilder.setBaseUri(baseURI);
        addAuthorization();
        if(header!=null) {
            specBuilder.addHeaders(header);
        }
        if(queryParam!=null) {
            specBuilder.addQueryParams(queryParam);
        }
        return specBuilder.build();
    }

    public void setContentType(String contentType) {

        switch (contentType.toLowerCase()) {

            case "json":
                specBuilder.setContentType(ContentType.JSON);
                break;

            case "multipart":
                specBuilder.setContentType(ContentType.MULTIPART);
                break;

        }


    }


    public RequestSpecification createSpecReuestSpec(Object requestBody , String contentType, Map<String, String>header) {

        specBuilder.setBaseUri(baseURI);
        addAuthorization();
        setContentType(contentType);
        if(header!=null) {
            specBuilder.addHeaders(header);
        }
        if(requestBody!=null) {
            specBuilder.setBody(requestBody);
        }
        return specBuilder.build();
    }

    public RequestSpecification createSpecReuestSpec(Object requestBody , String contentType) {

        specBuilder.setBaseUri(baseURI);
        addAuthorization();
        setContentType(contentType);
        if(requestBody!=null) {
            specBuilder.setBody(requestBody);
        }
        return specBuilder.build();
    }

    //get call
    public Response get(String serviceURL){

       Response response = RestAssured.given(createSpecReuestSpec()).log().all()
                .when().log().all()
                .get(serviceURL);

       return response;
    }

    public Response get(String serviceURL, Map<String,String>header){

        Response response = RestAssured.given(createSpecReuestSpec(header)).log().all()
                .when().log().all()
                .get(serviceURL);

        return response;
    }
    public Response get(String serviceURL, Map<String,String> header, Map<String, String> queryParam){

        Response response = RestAssured.given(createSpecReuestSpec(header,queryParam))
                .when().log().all()
                .get(serviceURL);

        return response;
    }

    //post call
    public Response post(String serviceURL, Object requestBody, String contentType, Map<String, String> header ){

      Response response = RestAssured.given(createSpecReuestSpec(requestBody,contentType,header))
                .when()
                .post(serviceURL);

      return response;
    }

    public Response post(String serviceURL, Object requestBody, String contentType ){

        Response response = RestAssured.given(createSpecReuestSpec(requestBody,contentType))
                .when().log().all()
                .post(serviceURL);

        return response;
    }


    //Put Call

    public Response put(String serviceURL, Object requestBody, String contentType, Map<String, String> header ){

        Response response = RestAssured.given(createSpecReuestSpec(requestBody,contentType,header))
                .when()
                .put(serviceURL);

        return response;
    }

    public Response put(String serviceURL, Object requestBody, String contentType ){

        Response response = RestAssured.given(createSpecReuestSpec(requestBody,contentType))
                .when()
                .put(serviceURL);

        return response;
    }

}
