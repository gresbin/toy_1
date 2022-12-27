package com.example.toy1.controller;

import com.example.toy1.dto.exception.common.InvalidParameterException;
import com.example.toy1.dto.exception.user.DuplicateIdException;
import com.example.toy1.dto.exception.user.DuplicateNicknameException;
import com.example.toy1.dto.user.SignUpRequestDto;
import com.example.toy1.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/auth/signup")
    @ApiOperation(value = "회원가입", notes = "회원정보를 통해 회원을 추가한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success")
    })
    public ResponseEntity<String> signup(@Valid @RequestBody SignUpRequestDto requestDto, BindingResult result) {
        if (result.hasErrors()) {
            throw new InvalidParameterException(result);
        } else if (userService.checkId(requestDto.getId())) {
            throw new DuplicateIdException();
        } else if (userService.checkNickname(requestDto.getNickname())) {
            throw new DuplicateNicknameException();
        }
        userService.signup(requestDto);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}
