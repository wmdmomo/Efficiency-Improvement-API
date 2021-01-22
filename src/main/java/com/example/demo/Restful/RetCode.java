package com.example.demo.Restful;

public enum RetCode {
    SUCCESS(200),
    FAIL(400),
    FALSE(404),
    ERROR(500);
    private int code;
    private RetCode(Integer code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }
    public void setCode(Integer code){
        this.code=code;

    }

}
