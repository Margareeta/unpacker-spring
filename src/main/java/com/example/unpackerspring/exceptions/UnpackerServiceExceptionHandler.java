package com.example.unpackerspring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UnpackerServiceExceptionHandler {
    private static final String DIGIT_AND_BRACKETS_MESSAGE =
            "The line contains no brackets between a number and a letter";
    private static final String LATIN_LETTER_MESSAGE =
            "The line contains symbols other than latin letters and numbers";
    private static final String PAIR_OF_BRACKETS_MESSAGE =
            "The line does not contain any pairs of square brackets";
    private static final String SPACE_SYMBOL_MESSAGE =
            "The line contains a Space symbol.";

    @ExceptionHandler(DigitAndBracketsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleDigitAndBracketsException(){return DIGIT_AND_BRACKETS_MESSAGE;}

    @ExceptionHandler(LatinLetterException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleLatinLetterException(){return LATIN_LETTER_MESSAGE;}

    @ExceptionHandler(PairOfBracketsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlePairofBracketsException(){return PAIR_OF_BRACKETS_MESSAGE;}

    @ExceptionHandler(SpaceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleSpaceException(){return SPACE_SYMBOL_MESSAGE;}
}
