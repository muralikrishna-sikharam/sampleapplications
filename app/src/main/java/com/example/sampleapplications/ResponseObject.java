package com.example.sampleapplications;

// on below line creating a class for response object.
public class ResponseObject {
    // on below line creating a variable for message.
    private String message;

    // on below line creating a constructor method.l
    public ResponseObject(String message) {
        this.message = message;
    }

    // on below line creating a getter method.
    public String getMessage() {
        return message;
    }

    // on below line creating a setter method.
    public void setMessage(String message) {
        this.message = message;
    }
}