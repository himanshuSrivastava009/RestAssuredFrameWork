package com.qa;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestAssuredClasses {

    public static void main(String[] args) {

        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
      RequestSpecification specification =  specBuilder.setBaseUri("https://blr8-116-90.apac.novell.com:8443").build();

            specBuilder.setBasePath("/rest/self").build();
        RestAssured.given(specification)
                .auth().preemptive().basic("admin", "novell")
                .relaxedHTTPSValidation()
                .when().log().all()
                .get("/rest/self")

                .then()

                .statusCode(200);

//        Integer i = 200;
//        RestAssured.given()
//                .auth()
//                .preemptive()
//                .basic("admin","novell")
//                .relaxedHTTPSValidation()
//                .when().log().all()
//                .get("https://blr8-116-90.apac.novell.com:8443/rest/self")
//                .then().log().all()
//                .assertThat()
//                .equals(i);



    }
}
