package com.fan.springcloud.entities;

import java.util.Objects;

public class CommonResult<T>  { //泛型表示通用，传过来的是什么类型，那么传过去还是什么类型
    private Integer code; //表示传过去的是一个400 200等.. 编码
    private String message; //表示传到前端的消息
    private T date; //属性

    public CommonResult() {
    }

    //有可能第三个值可能为null，所有要添加一个两个值的方法
    public CommonResult(Integer code, String message) {
        //调用有参构造方法
        this(code,message,null);
    }

    public CommonResult(Integer code, String message, T date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonResult<?> that = (CommonResult<?>) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(message, that.message) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, date);
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
