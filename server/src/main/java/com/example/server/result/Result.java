package com.example.server.result;

import lombok.Data;

@Data
public class Result {
    private static final int SUCCESS = 200;
    private static final int FAIL = 500;

    private int code;

    private Object data;

    public Result() {
        this.code = 0;
    }

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public static Result error(String msg) {
        return fail(msg);
    }

    public static Result success() {
        return new Result(SUCCESS);
    }

    public static Result success(Object data) {
        return new Result(SUCCESS, data);
    }


    public static Result fail() {
        return new Result(FAIL);
    }

    public static Result fail(Object data) {
        return new Result(FAIL, data);
    }
}
