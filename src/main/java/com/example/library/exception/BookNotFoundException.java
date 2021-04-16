package com.example.library.exception;

import com.example.library.model.enums.ErrorType;

public class BookNotFoundException extends ServiceException{
    private static final String DEFAULT_MESSAGE = "Book is not found";


    public BookNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public BookNotFoundException(String message){
        super(message);
    }

    @Override
    public ErrorType getErrorType(){
        return ErrorType.DATABASE_ERROR_TYPE;
    }

}
