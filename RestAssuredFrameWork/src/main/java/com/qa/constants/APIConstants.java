package com.qa.constants;

public enum APIConstants {

    OK_200(200,"OK"),
    CREATED_201(201, "CREATED"),
    NO_CONTENT_204(204, "NO CONTENT"),
    BAD_REQUEST_400(400,"BAD REQUEST"),
    UNAUTHORISED_401(401,"UNAUTHORISED"),
    INTERNAL_SERVER_ERROR_500(500,"INTERNAL SERVER ERROR"),
    NOT_FOUND_404(404,"NOT FOUND"),
    FORBIDDEN_403(403,"FORBIDDNE");


    private int code;
    private String message;
    APIConstants(int code, String message) {

        this.code=code;
        this.message=message;
    }

    public int getCode(){
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
  public String  toString(){

        return code +" " +message;
    }
}
