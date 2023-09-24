package com.qa.test.Post;

import com.qa.Restclient.RestClient;
import com.qa.pojo.User;
import com.qa.test.BaseTest;
import com.qa.utilities.RandomEmailGen;
import com.qa.utilities.RandomUserIDGen;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import static org.hamcrest.Matchers.*;

public class CreateUser extends BaseTest {



    Response response;
    ArrayList<Integer> ids;
    Iterator<Integer> it;

    @BeforeMethod
    public void initRestClient(){
        restClient = new RestClient(properties,baseURL);
    }
    @Test
    public void createUser() {

        //1.Post call

        User user = User.builder()
                        .id(RandomUserIDGen.generateUserID())
                                .name("himanshuKumar SS")
                                                .email(RandomEmailGen.randomEmailGenerator())
                .gender("male")
                .status("Active")
                .build();

     // Integer userID =  restClient.post("/public/v2/users",user, "json")
            //  .then().extract().path("id");

      response = restClient.post("/public/v2/users",user, "json");

       Integer userID = response.getBody().jsonPath().get("id");

        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("UserID is ====" +userID);


        //2.Get Call

        RestClient rst = new RestClient(properties,baseURL);
        rst.get("/public/v2/users/"+userID)
                .then().log().all();



    }
}
