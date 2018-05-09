package com.github.dibyaranjan.airlineportal.modelobjects.json.wrapper;

import com.github.dibyaranjan.airlineportal.modelobjects.status.ErrorMessage;
import com.github.dibyaranjan.airlineportal.modelobjects.status.StatusType;

public interface GenericJsonWrapper<T> {
    public static Class<?> getJsonWrapper() {
        return null;
    }

    void setStatus(StatusType status);

    void setError(ErrorMessage e);

    void setData(T data);
}
