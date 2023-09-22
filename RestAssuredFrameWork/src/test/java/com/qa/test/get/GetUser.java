package com.qa.test.get;

import com.qa.Restclient.RestClient;
import com.qa.pojo.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class GetUser {

    RestClient restClient;
    Response response;
    ArrayList<Integer> ids;
    Iterator<Integer> it;

    @Test
    public void getUsers(){
        restClient = new RestClient();

        restClient.get("/public/v2/users/")
                .then().log().all()
                .assertThat()
                .statusCode(200);

    }

    @Test
    public void getUsers1() {
        restClient = new RestClient();

        Response response = restClient.get("/public/v2/users/");
        ArrayList<String> ids = response.body().jsonPath().get("name");
        System.out.println(ids);
        Iterator<String> it = ids.iterator();

        while (it.hasNext()) {

            System.out.println(it.next());
        }

    }
        @Test
        public void getUsers2(){
            restClient = new RestClient();

          restClient.get("/public/v2/users/")
                  .then()
                  .assertThat()
                  .body("id", hasItem(5181896));



        }

    @Test
    public void getUsersWithQueryParam(){
        restClient = new RestClient();

        Map<String, String> map = new HashMap<>();
        map.put("name","Aaditya Dubashi");
        restClient.get("/public/v2/users/",null,map)
                .then()
                .assertThat()
                .statusCode(200);




    }


}
