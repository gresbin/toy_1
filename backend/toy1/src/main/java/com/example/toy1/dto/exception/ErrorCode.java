package com.example.toy1.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(404, "U001", "회원정보를 찾을 수 없습니다."),
    DUPLICATE_EMAIL(400, "U002", "이미 존재하는 이메일입니다."),
    DUPLICATE_NICKNAME(400, "U003", "이미 존재하는 별명입니다."),
    DUPLICATE_ID(400, "U004", "이미 존재하는 아이디입니다."),
    INVALID_PARAMETER(400, "U005", "잘못된 요청입니다."),
    POST_NOT_FOUND(400, "U006", "게시글을 찾을 수 없습니다.");

    private final int status;
    private final String code;
    private final String message;
}
