package com.qa.test.get;

import com.qa.Restclient.RestClient;
import com.qa.pojo.User;
import com.qa.test.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.Matchers.*;

public class GetUser extends BaseTest {

    @BeforeMethod
    public void initRestClient() {

        restClient = new RestClient(properties, baseURL);
    }

//    @Test
//    public void testMethods() {
//
//        restClient.get("/rest/self", "admin", "opentext")
//                .then().log().all()
//                .assertThat()
//                .statusCode(200)
//                .extract()
//                .body().toString();
//    }

    @Test
    public void getDlp() {

        //rest/admin/dlp/policies
     Response response =   restClient.get("/rest/admin/dlp/policies","admin","opentext");

     JsonPath jsonPath = response.getBody().jsonPath();

     List<String> value = jsonPath.getList("dlp_classification_level.title");

        for (String val: value) {
            System.out.println("value ==========" +val);

            Assert.assertEquals(val, "himanshu" );
        }


    }

}
