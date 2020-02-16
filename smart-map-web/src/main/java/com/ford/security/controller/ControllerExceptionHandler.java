package com.ford.security.controller;


/*@ControllerAdvice
public class ControllerExceptionHandler {

    *//**
     * 当程序中有抛出UserNotExistException异常的时候，都会默认到这里来处理
     *//*
    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotExistException(UserNotExistException ex) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", ex.getId());
        result.put("message", ex.getMessage());
        return result;
    }
}*/
