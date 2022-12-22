package com.example.toy1.dto.exception.user;

import com.example.toy1.dto.exception.CustomException;
import com.example.toy1.dto.exception.ErrorCode;

public class DuplicateNicknameException extends CustomException {
    public DuplicateNicknameException() { super(ErrorCode.DUPLICATE_NICKNAME);}
}
