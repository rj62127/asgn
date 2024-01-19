package com.authservice.authservice.utils.constants;

public final class Message {

    private Message() {
    }

    public static final String NAME_EMPTY = "User name can't be empty";
    public static final String EMAIL_EMPTY = "Email can't be empty";
    public static final String INVALID_EMAIL_FORMAT = "Invalid email format";
    public static final String PASSWORD_COMPLEXITY = "Password must be at least 8 characters long and contain at least one digit, one lowercase letter, one uppercase letter, and one special character.";
    public static final String EMAIL_INVALID_FORMAT = "Invalid email format.";
    public static final String PASSWORD_EMPTY = "Password can't be empty";
    public static final String INVALID_PASSWORD_LENGTH = "Password must have at least 8 characters";
    public static final String USER_EXISTS = "User with email already exists: ";
    public static final String SIGN_UP_SUCCESSFUL = "User signed up successfully";
    public static final String USER_NOT_FOUND = "User not found by email: ";
    public static final String AUTH_HEAD_NOT_FOUND = "Authorization header is missing.";
}
