package com.ford.security.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private int code=800;
    private String message;
    private T data;
    
    
    public Response(String message) {
        this.message = message;
    }
}
