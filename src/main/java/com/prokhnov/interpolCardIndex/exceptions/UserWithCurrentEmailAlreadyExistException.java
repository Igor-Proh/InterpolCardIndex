package com.prokhnov.interpolCardIndex.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * The {@code UserWithCurrentEmailAlreadyExistException} class extends {@code AuthenticationException}.<br/>
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
public class UserWithCurrentEmailAlreadyExistException extends AuthenticationException {
    public UserWithCurrentEmailAlreadyExistException(final String msg) {
        super(msg);
    }

}
