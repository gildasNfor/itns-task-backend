package com.test.intern.canal.exceptions;

public class CanalAlreadyExistException extends RuntimeException {

    public CanalAlreadyExistException(String name) {
        super("Canal with name " + name + " already Exist");
    }

}
