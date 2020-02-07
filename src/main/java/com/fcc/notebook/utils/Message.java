package com.fcc.notebook.utils;

public class Message {

    private int code;

    private String msg;

    private Object data;


    public static Message createSuc(Object o) {

        return new Message(0, null, o);
    }


    public static Message createErr(String msg) {
        return new Message(-1, msg, null);
    }


    public Message(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    public static Message ok() {
        return new Message(200, "Ok", null);
    }

    public static Message notFound() {
        return new Message(404, "Not Found", null);
    }

    public static Message badRequest() {
        return new Message(400, "Bad Request", null);
    }

    public static Message forbidden() {
        return new Message(403, "Forbidden", null);
    }

    public static Message unauthorized() {
        return new Message(401, "unauthorized", null);
    }

    public static Message serverInternalError() {
        return new Message(500, "Server Internal Error", null);
    }

    public static Message customerError() {
        return new Message(1001, "customer Error", null);
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {

        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
