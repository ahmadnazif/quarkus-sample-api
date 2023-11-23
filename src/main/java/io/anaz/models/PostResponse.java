package io.anaz.models;

public class PostResponse {
    protected boolean isSuccess;
    protected String message;

    public PostResponse(boolean isSuccess, String message){
        this.isSuccess = isSuccess;
        this.message = message;
    }
}
