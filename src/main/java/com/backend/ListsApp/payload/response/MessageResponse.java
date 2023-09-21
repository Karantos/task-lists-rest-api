package com.backend.ListsApp.payload.response;

// Class that is used to represent a simple message that is returned to the user in response to a request.
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
