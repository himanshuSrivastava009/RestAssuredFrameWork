package com.qa.test.get;

import com.qa.Restclient.RestClient;
import com.qa.test.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GetGoRestApi extends BaseTest {


    @BeforeMethod
    public  void initRestClient(){

        restClient = new RestClient(properties,baseURL);
    }



    @Test
    public void getUsers(){


        restClient.get("/public/v2/users/")
                .then().log().all()
                .assertThat()
                .statusCode(200);

    }

    @Test
    public void getUsers1() {


        Response response = restClient.get("/public/v2/users/");
        ArrayList<String> ids = response.body().jsonPath().get("name");
        System.out.println(ids);
        Iterator<String> it = ids.iterator();

        while (it.hasNext()) {

            System.out.println(it.next());
        }

    }

    @Test
    public void getUsersWithQueryParam(){


        Map<String, String> map = new HashMap<>();
        map.put("name","Aaditya Dubashi");
        restClient.get("/public/v2/users/",null,map)
                .then()
                .assertThat()
                .statusCode(200);




    }

}



