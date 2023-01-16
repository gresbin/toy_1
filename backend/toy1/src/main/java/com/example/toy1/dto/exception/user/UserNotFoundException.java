package com.example.toy1.dto.exception.user;

import com.example.toy1.dto.exception.CustomException;
import com.example.toy1.dto.exception.ErrorCode;

public class UserNotFoundException extends CustomException {
    public UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
