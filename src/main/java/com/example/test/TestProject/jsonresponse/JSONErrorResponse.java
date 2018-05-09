package com.example.test.TestProject.jsonresponse;

import java.util.Objects;
import com.example.test.TestProject.exceptions.Error;

public class JSONErrorResponse {
    private Error error;

    @Override
    public String toString() {
        return "JSONErrorResponse{" +
                "error=" + error +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JSONErrorResponse that = (JSONErrorResponse) o;
        return Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {

        return Objects.hash(error);
    }

    public Error getError() {

        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public JSONErrorResponse(Error error) {

        this.error = error;
    }
}
