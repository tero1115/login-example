package com.example.loginexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.loginexample.dto.user.UserReq.JoinReqDto;
import com.example.loginexample.dto.user.UserReq.LoginReqDto;
import com.example.loginexample.handler.ex.CustomException;
import com.example.loginexample.model.User;
import com.example.loginexample.model.UserRepository;
import com.example.loginexample.util.Sha256;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User 로그인(LoginReqDto loginReqDto) {
        String password = Sha256.hashPassword(loginReqDto.getPassword());

        User principal = userRepository.findByUsernameAndPassword(
                loginReqDto.getUsername(), password);
        if (principal == null) {
            throw new CustomException("유저네임 혹은 패스워드가 잘못 입력되었습니다");
        }
        return principal;
    }

    @Transactional
    public void 회원가입(JoinReqDto joinReqDto) {
        User sameUser = userRepository.findByUsername(joinReqDto.getUsername());
        if (sameUser != null) {
            throw new CustomException("동일한 username이 존재합니다");
        }
        String password = Sha256.hashPassword(joinReqDto.getPassword());

        int result = userRepository.insert(joinReqDto.getUsername(), password, joinReqDto.getEmail());
        if (result != 1) {
            throw new CustomException("회원가입실패");
        }
    }

}
