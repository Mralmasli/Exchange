package com.example.exchange.data.network.model;

import com.google.gson.annotations.SerializedName;

public class GenericModel<T> {

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GenericModel{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
