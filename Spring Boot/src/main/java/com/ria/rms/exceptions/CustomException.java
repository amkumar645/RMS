package com.ria.rms.exceptions;

import lombok.Data;

/**
 * @author YeshaAgrawal
 */
@Data
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer statusCode;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Integer statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

}
