package com.example.test.TestProject.jsonresponse;

import java.util.Objects;

public class JSONResponse<T> {
    private T data;

    @Override
    public String toString() {
        return "JSONResponse{" +
                "data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JSONResponse<?> that = (JSONResponse<?>) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data);
    }

    public T getData() {

        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public JSONResponse(T data) {

        this.data = data;
    }
}
