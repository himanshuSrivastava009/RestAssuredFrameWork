package com.qa.test.Post;

import com.qa.Restclient.RestClient;
import com.qa.pojo.CreateDlpPoliciesPojo;
import com.qa.test.BaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class CreateDLPPolicies extends BaseTest {

    @BeforeMethod
    public void initRestClient() {
        restClient = new RestClient(properties, baseURL);
    }

    @Test
    public void createDLPPolicies() {
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Accept", "*/*");

        CreateDlpPoliciesPojo dlpPoliciesPojo = CreateDlpPoliciesPojo
                .builder()
                .id(1)
                .title("Himanshu")
                .enabled(true)
                .build();
        Response response = restClient.put("/rest/admin/dlp/policies", dlpPoliciesPojo, "json", headerMap, "admin", "opentext");
        String responseBody = response.getBody().asString();
        System.out.println("========================" + responseBody);
        JsonPath jsonPath = response.getBody().jsonPath();
        String title = jsonPath.get("dlp_classification_level.title");
        Assert.assertEquals(title, dlpPoliciesPojo.getTitle());

    }

    @Test
    public void uploadFile(){

        //https://blr8-110-205.apac.novell.com:8443/rest/folders/2390/library_files?file_name=Icon_File_In_My_FIles.png&include_user_quota=true&mod_date=2023-01-31T12%3A30%3A00Z
        //Headers required
        /***
         * Content-Type:
         * multipart/form-data
         * Accept:
         * /
         */
        RestAssured.baseURI ="https://blr8-110-206.apac.novell.com:8443";
        HashMap<String,String> headerMap = new HashMap<>();
        HashMap<String,Object> queryMap = new HashMap<>();

        queryMap.put("file_name" ,"Arrows.dxf");
        queryMap.put("include_user_quota", true);
        headerMap.put("Content-type","multipart/form-data");
        restClient.post("/rest/folders/2390/library_files",headerMap,queryMap,"himanshu","novell@123", "E:\\All Files\\Small Size of ALL file types\\Arrows.dxf")
                        .then()
                                .statusCode(200);

//        RestAssured.given().log().all()
//               // .formParam("multipart/form-data", "E:\\All Files\\Small Size of ALL file types\\Arrows.dxf")
//                .header("Content-type","multipart/form-data")
//                .multiPart("file", new File("E:\\All Files\\Small Size of ALL file types\\Arrows.dxf"))
//                .queryParam("file_name","Arrows.dxf")
//                .and()
//                .queryParam("include_user_quota", true)
//                .auth()
//                .preemptive()
//                .basic("himanshu", "novell@123")
//                .relaxedHTTPSValidation()
//                .when().log().all()
//                .get("/rest/folders/2390/library_files")
//                .then().log().all()
//                .statusCode(200);

    }
}
