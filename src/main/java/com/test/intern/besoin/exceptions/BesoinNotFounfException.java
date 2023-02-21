package com.test.intern.besoin.exceptions;

public class BesoinNotFounfException extends RuntimeException {

    public BesoinNotFounfException(String id) {
        super("Canal with ID " + id + " does not exist");
    }

}
