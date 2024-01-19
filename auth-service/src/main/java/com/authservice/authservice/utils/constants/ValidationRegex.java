package com.authservice.authservice.utils.constants;

public final class ValidationRegex {


    private ValidationRegex() {

    }

    public static final String EMAIL_REGEX = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}";
    public static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
}
