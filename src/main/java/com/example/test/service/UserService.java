package com.example.test.service;

import com.example.test.entity.User;
import com.example.test.repository.UserRepository;
import com.example.test.vo.Login;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User get(int id) {
        User user = userRepository.findById(id).get();
        user.setPassword("");
        return user;
    }

    public boolean sign(User user) {
        boolean result = checkTel(user.getTel());
        if (result) {
            userRepository.save(user);
            return true;
        }

        return false;
    }

    public boolean login(Login login) {
        int i = userRepository.login(login.getId(), login.getPassword());
        if (i > 0) {
            return true;
        }

        return false;
    }

    public Map<String, String> resetPassword(int id) {
        User user = userRepository.findById(id).get();
        boolean result = checkTel(user.getTel());
        Map map = new HashMap<String, String>();
        map.put("result", "false");
        map.put("password", null);

        if (result) {
            String password = generateRandomPassword(10);
            user.setPassword(password);
            userRepository.save(user);
            map.put("result", "true");
            map.put("password", password);
            return map;
        }

        return map;
    }

    public boolean checkTel(String tel) {
        // 전화번호 인증
        return true;
    }

    // 특정 길이의 임의의 영숫자 비밀번호를 생성하는 메소드
    public static String generateRandomPassword(int len) {
        // ASCII 범위 – 영숫자(0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        // 루프의 각 반복은 주어진 문자에서 무작위로 문자를 선택합니다.
        // ASCII 범위를 `StringBuilder` 인스턴스에 추가합니다.
        return IntStream.range(0, len)
                .map(i -> random.nextInt(chars.length()))
                .mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex)))
                .collect(Collectors.joining());
    }
}
