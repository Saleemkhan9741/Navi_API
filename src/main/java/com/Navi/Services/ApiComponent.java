package com.Navi.Services;

import io.restassured.response.Response;

import java.util.Map;


public class ApiComponent {
    public String baseUrl;
    public String username;
    public String password;
    public String endPoint;
    public String payload;
    public Map<String, Object> headers;
    public Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public ApiComponent() {
    }

    public ApiComponent(String baseUrl, String username, String password, String endPoint, String payload, Map<String , Object> headers, Response response) {
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
        this.endPoint = endPoint;
        this.payload = payload;
        this.headers = headers;
        this.response = response;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Map<String, Object> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }
}
