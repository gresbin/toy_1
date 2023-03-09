package com.example.toy1.dto.exception.article;

import com.example.toy1.dto.exception.CustomException;
import com.example.toy1.dto.exception.ErrorCode;
import org.springframework.validation.Errors;

public class PostNotFoundException extends CustomException {

    public PostNotFoundException() {super(ErrorCode.POST_NOT_FOUND);}
}
