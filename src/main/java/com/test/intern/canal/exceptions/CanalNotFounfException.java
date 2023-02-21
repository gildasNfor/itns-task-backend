package com.test.intern.canal.exceptions;

public class CanalNotFounfException extends RuntimeException {

    public CanalNotFounfException(String id) {
        super("Canal with ID " + id + " does not exist");
    }

}
