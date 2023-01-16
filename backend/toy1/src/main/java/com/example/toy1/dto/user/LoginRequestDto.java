package com.example.toy1.dto.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "LoginRequestDto", description = "로그인 요청 Dto")
public class LoginRequestDto {
    @NotBlank
    private String username;
    @NotBlank
    private String pw;
}
