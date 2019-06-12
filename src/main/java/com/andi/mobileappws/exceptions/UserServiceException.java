package com.andi.mobileappws.exceptions;



public class UserServiceException extends RuntimeException {

    public static final long serialVersionUID = -8595601516019814828L;

    public UserServiceException(String message) {
        super(message);
    }

}
