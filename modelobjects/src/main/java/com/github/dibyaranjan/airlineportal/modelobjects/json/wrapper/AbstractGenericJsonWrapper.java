package com.github.dibyaranjan.airlineportal.modelobjects.json.wrapper;

import com.github.dibyaranjan.airlineportal.modelobjects.status.ErrorMessage;
import com.github.dibyaranjan.airlineportal.modelobjects.status.StatusType;

public abstract class AbstractGenericJsonWrapper<T> implements GenericJsonWrapper<T> {
    private StatusType status;
    private ErrorMessage error;
    private T data;

    public ErrorMessage getError() {
        return error;
    }

    @Override
    public void setError(ErrorMessage e) {
        this.error = e;
    }

    public StatusType getStatus() {
        return status;
    }

    @Override
    public void setStatus(StatusType status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public abstract void setData(T data);
}
