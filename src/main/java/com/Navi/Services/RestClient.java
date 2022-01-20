package com.Navi.Services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;


enum HTTYType {
    GET,
    PUT,
    POST,
    DELETE
}

public class RestClient {
    public RequestSpecification request;
    public Response response;
    public String baseUrl;
    public String userName;
    public String password;

    public RestClient(String baseUrl){
        this.baseUrl = baseUrl;
    }

    public RestClient(String baseUrl, String userName, String password ){
        this.userName = userName;
        this.password = password;
        this.baseUrl = baseUrl;
        setbasicauth(userName, password);
    }

    public void setbasicauth(String userName, String password){
        request.auth().preemptive().basic(userName,password);
    }

    public Response whenRequestIsInvoked(String HttpType, Map<String, Object> headers, String endPoint, String payload, String queryparams, String entityId) throws Exception {
        RestAssured.baseURI = this.baseUrl;
        request=RestAssured.given();
        if(headers !=null){
            request.headers(headers);
        }
        if(payload != null){
            request.body(payload);
        }

        endPoint = formattedURl(endPoint,queryparams,entityId);

        switch (HttpType){
            case "GET":
                if(endPoint != null) {
                    return request.get(endPoint);
                }else {return request.get();}
            case "PUT":
                if(endPoint != null) {
                    return request.put(endPoint);
                }else return request.put();
            case "POST":
                if(endPoint != null) {
                    return request.post(endPoint);
                }else return request.delete();
            case "DELETE":
                if(endPoint != null) {
                    return request.delete(endPoint);
                }else return request.delete();
            default:
                throw  new Exception("EndPoint is not defined");
        }
    }

    public String formattedURl(String endpoint, String params, String entityId){

        if(params != null){
            endpoint = endpoint + "?"+params;
        }

        if(entityId != null){
            endpoint = endpoint + "/" +entityId ;
        }
        return endpoint;
    }






}
