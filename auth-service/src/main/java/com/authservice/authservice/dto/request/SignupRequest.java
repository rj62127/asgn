package com.authservice.authservice.dto.request;

import com.authservice.authservice.utils.constants.Message;
import com.authservice.authservice.utils.constants.ValidationRegex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    @NotEmpty(message = Message.NAME_EMPTY)
    private String name;

    @NotEmpty(message = Message.EMAIL_EMPTY)
    @Email(regexp = ValidationRegex.EMAIL_REGEX,
            flags = Pattern.Flag.CASE_INSENSITIVE, message = Message.EMAIL_INVALID_FORMAT)
    private String email;

    @NotEmpty(message = Message.PASSWORD_EMPTY)
    @Size(min = 8, message = Message.INVALID_PASSWORD_LENGTH)
    @Pattern(regexp = ValidationRegex.PASSWORD_REGEX,
            message = Message.PASSWORD_COMPLEXITY)
    private String password;

}