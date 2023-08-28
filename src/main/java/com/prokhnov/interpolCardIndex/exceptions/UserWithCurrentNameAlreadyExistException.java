package com.prokhnov.interpolCardIndex.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * The {@code UserWithCurrentNameAlreadyExistException} class extends {@code AuthenticationException}.<br/>
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
public class UserWithCurrentNameAlreadyExistException extends AuthenticationException {

    public UserWithCurrentNameAlreadyExistException(final String msg) {
        super(msg);
    }

}
