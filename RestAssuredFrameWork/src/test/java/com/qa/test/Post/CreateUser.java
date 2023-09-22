package com.qa.test.Post;

import com.qa.Restclient.RestClient;
import com.qa.pojo.User;
import com.qa.utilities.RandomEmailGen;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import static org.hamcrest.Matchers.*;

public class CreateUser {



    Response response;
    ArrayList<Integer> ids;
    Iterator<Integer> it;

    @Test
    public void createUser() {

        //1.Post call
      RestClient  restClient = new RestClient();
        User user = User.builder()
                        .id(998044)
                                .name("himanshuKumar SS")
                                                .email(RandomEmailGen.randomEmailGenerator())
                .gender("male")
                .status("Active")
                .build();

      Integer userID =  restClient.post("/public/v2/users",user, "json")
              .then().extract().path("id");


        System.out.println("UserID is ====" +userID);


        //2.Get Call

        RestClient restClientGet = new RestClient();
        restClientGet.get("/public/v2/users/"+userID)
                .then().log().all();



    }
}
