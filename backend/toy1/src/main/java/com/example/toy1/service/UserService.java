package com.example.toy1.service;

import com.example.toy1.dto.user.SignUpRequestDto;

public interface UserService {
    public void signup(SignUpRequestDto dto);
    boolean checkId(String userid);
    boolean checkNickname(String nickname);
}
