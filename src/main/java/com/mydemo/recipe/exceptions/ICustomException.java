package com.mydemo.recipe.exceptions;

import org.springframework.http.HttpStatus;

public interface ICustomException {
    HttpStatus getStatus();
}