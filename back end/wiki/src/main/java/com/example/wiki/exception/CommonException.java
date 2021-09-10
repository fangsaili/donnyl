package com.example.wiki.exception;

public class CommonException extends RuntimeException{
    private CommonExceptionCode code;

    public CommonException(CommonExceptionCode code) {
        super(code.getDesc());
        this.code = code;
    }

    public CommonExceptionCode getCode() {
        return code;
    }

    public void setCode(CommonExceptionCode code) {
        this.code = code;
    }

    @Override
    public Throwable fillInStackTrace(){return this;}
}
