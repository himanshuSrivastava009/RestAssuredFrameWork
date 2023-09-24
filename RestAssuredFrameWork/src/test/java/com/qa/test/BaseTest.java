package com.qa.test;

import com.qa.Restclient.RestClient;
import com.qa.configuration.ConfigurationManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {

   protected ConfigurationManager configurationManager;
   protected Properties properties;
    protected RestClient restClient;
    protected String baseURL;

    @Parameters({"baseURL"})
    @BeforeTest
    public void setup(String baseURL){
        RestAssured.filters(new AllureRestAssured());
      configurationManager = new ConfigurationManager();
      properties =  configurationManager.initProp();
      this.baseURL = baseURL;
     // restClient = new RestClient(properties,baseURL);

    }
}
