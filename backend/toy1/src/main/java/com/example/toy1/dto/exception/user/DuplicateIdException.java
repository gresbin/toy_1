package com.example.toy1.dto.exception.user;

import com.example.toy1.dto.exception.CustomException;
import com.example.toy1.dto.exception.ErrorCode;

public class DuplicateIdException extends CustomException {
    public DuplicateIdException () { super(ErrorCode.DUPLICATE_ID); }
}
