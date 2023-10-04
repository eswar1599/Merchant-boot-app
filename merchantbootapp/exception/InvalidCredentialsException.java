package org.jsp.merchantbootapp.exception;

public class InvalidCredentialsException extends RuntimeException
{
	@Override
	public String getMessage() {
		return "Invalid phone or password or id or email";
	}
}
