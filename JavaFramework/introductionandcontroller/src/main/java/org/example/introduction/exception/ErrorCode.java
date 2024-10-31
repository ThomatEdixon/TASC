package org.example.introduction.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(999, "Uncategorized error"),
    INVALID_KEY(101, "Uncategorized error"),
    USER_EXISTED(100, "User existed"),
    FIRSTNAME_INVALID(103, "First name must be at least 3 characters"),
    LASTNAME_INVALID(104, "Last name must be at least 3 characters")    
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;
}
