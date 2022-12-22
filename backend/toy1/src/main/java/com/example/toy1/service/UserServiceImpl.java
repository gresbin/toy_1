package com.example.toy1.service;

import com.example.toy1.domain.User;
import com.example.toy1.domain.enums.Role;
import com.example.toy1.dto.user.SignUpRequestDto;
import com.example.toy1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signup(SignUpRequestDto dto) {
        // User 클래스 틀에 맞춰 값 집어넣기
        User user = User.builder()
                .userid(dto.getId())
                .pw(passwordEncoder.encode(dto.getPw()))
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .role(Role.USER)
                .build();

        // 문제없으면 저장
        try {
            userRepository.save(user);
        // 문제가 생기면 오류 발생
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkId(String userid) {
        // user id로 검색 후 존재유무를 bool값으로 전달
        Optional<User> entity = userRepository.findByUserId(userid);
        return entity.isPresent();
    }

    @Override
    public boolean checkNickname(String nickname) {
        // user nickname으로 검색 후 존재유무를 bool값으로 전달
        Optional<User> entity = userRepository.findByNickname(nickname);
        return entity.isPresent();
    }
}
