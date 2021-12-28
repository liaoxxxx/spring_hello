package com.liaoxx.spring_hello.exception;

public class AuthException extends Exception {

    //
    // 覆写 fillInStackTrace  只需要简单的知道一个描述问题的字符串即可，栈追踪信息对我们的意义并不大
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public AuthException(String msg) {
        super(msg);
    }
}
