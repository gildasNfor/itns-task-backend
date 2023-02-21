package com.test.intern.besoin.exceptions;

public class BesoinAlreadyExistException extends RuntimeException {

    public BesoinAlreadyExistException(String name) {
        super("Canal with name " + name + " already Exist");
    }

}
