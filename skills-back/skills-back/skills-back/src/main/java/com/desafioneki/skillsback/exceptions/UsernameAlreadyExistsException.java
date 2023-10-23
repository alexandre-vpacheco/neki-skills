package com.desafioneki.skillsback.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException {

	   public UsernameAlreadyExistsException() {
	        super("Nome de usuário já está em uso!");
	    }

	    public UsernameAlreadyExistsException(String message) {
	        super(message);
	    }

	    public UsernameAlreadyExistsException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
