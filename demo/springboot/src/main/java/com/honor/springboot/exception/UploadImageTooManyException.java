package com.honor.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * com.honor.springboot.exception
 *
 * @author honor-ljp
 * 2023/1/4 14:59
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "图片数量太多！")
public class UploadImageTooManyException extends RuntimeException {
    public UploadImageTooManyException() {

    }
    public UploadImageTooManyException(String message) {
        super(message);
    }
}
