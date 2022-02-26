package com.example.simplecrud_member.model.common;

import com.example.simplecrud_member.exception.InvalidRequestModelException;

public abstract class ValidatableRequestModel {
    public abstract void validate() throws InvalidRequestModelException;
}
