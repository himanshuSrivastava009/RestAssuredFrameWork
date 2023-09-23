package com.qa.Restclient;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;
import java.util.Properties;

public class RestClient {

     RequestSpecBuilder specBuilder;
    Properties prop;
    String baseURL;
    boolean isAuthorizationHeaderAdded = false;
    public RestClient(Properties prop, String baseURL){

        this.prop = prop;
        this.baseURL = baseURL;
        specBuilder = new RequestSpecBuilder();

    }

    public void addAuthorization() {

            if(!isAuthorizationHeaderAdded) {
                specBuilder.addHeader("Authorization", "Bearer " + prop.getProperty("tokenID"));
                isAuthorizationHeaderAdded = true;
            }


    }

    public RequestSpecification createSpecReuestSpec() {

        specBuilder.setBaseUri(baseURL);

        return specBuilder.build();
    }

    public RequestSpecification createSpecReuestSpec(Map<String, String> header) {

        specBuilder.setBaseUri(baseURL);
        addAuthorization();
        specBuilder.addHeaders(header);
        return specBuilder.build();
    }

    public RequestSpecification createSpecReuestSpec(Map<String, String> header, Map<String, String> queryParam) {

        specBuilder.setBaseUri(baseURL);
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

        specBuilder.setBaseUri(baseURL);
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

    //adding support for multipart form data

    /***
     *
     *
     * @param header
     * @param filePath
     * @return
     */
    public RequestSpecification createSpecReuestSpec( Map<String, String>header, Map<String, Object> queryMap, String filePath) {

        specBuilder.setBaseUri(baseURL);
        if(header!=null) {
            specBuilder.addHeaders(header);
        }
        specBuilder.addMultiPart("file", new File(filePath));

        if(queryMap!=null){
            specBuilder.addQueryParams(queryMap);
        }

        return specBuilder.build();
    }

    public RequestSpecification createSpecReuestSpec(Object requestBody , String contentType) {

        specBuilder.setBaseUri(baseURL);
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
    public Response get(String serviceURL, String username, String password){

       Response response = RestAssured.given(createSpecReuestSpec()).log().all()
               .auth()
               .preemptive()
               .basic(username , password)
               .relaxedHTTPSValidation()
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

    public Response post(String serviceURL, Map<String, String> header, Map<String,Object>queryMap, String username, String password, String filepath ){

        Response response = RestAssured.given(createSpecReuestSpec(header,queryMap,filepath))
                .auth()
                .preemptive()
                .basic(username,password)
                .relaxedHTTPSValidation()
                .when().log().all()
                .post(serviceURL);

        return response;
    }

    public Response put(String serviceURL, Object requestBody, String contentType, Map<String, String> header, String username, String password ){

        Response response = RestAssured.given(createSpecReuestSpec(requestBody,contentType,header))
                .when().log().all()
                .auth()
                .preemptive()
                .basic(username,password)
                .relaxedHTTPSValidation()
                .put(serviceURL);

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
