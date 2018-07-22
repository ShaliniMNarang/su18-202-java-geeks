package com.sjsu.javageeks.user.util;
/**
 * 
 * @author sunder
 *  This class was created to be used for Custom Error Message written as part of REST API
 *
 */
public class CustomMessageType {

    private String message;

    public CustomMessageType(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
