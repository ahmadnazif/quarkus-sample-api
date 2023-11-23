package io.anaz.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class PostResponse {
    public boolean isSuccess;
    public String message;

    public PostResponse(boolean isSuccess, String message){
        this.isSuccess = isSuccess;
        this.message = message;
    }
}
