package com.ds.restservice;

import org.apache.log4j.Logger;

import com.ds.pageobject.CreateUserPageObject;
import com.ds.utils.RequestPathUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * This class has all the calls to the Rest API.
 */
public class APIMethods {

    private APIMethods(){
    }
    /**
     * Method to get all the created users using RestAssured
     *
     * @param GET
     *            HTTP method
     * @return ResponseBody
     */

    public static Response getUsers(){
        return RestAssured.given().get(RequestPathUrl.GET_USERS);
    }

    /**
     * Method to delete all the created users using RestAssured
     *
     * @param DELETE
     *            HTTP method
     * @return ResponseBody
     */
    public static Response deleteUsers()  {
        return RestAssured.given().delete(RequestPathUrl.DELETE_USERS);

    }

}