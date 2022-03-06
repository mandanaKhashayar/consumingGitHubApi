package com.mandana.firstspringbootproject.services;

import com.mandana.firstspringbootproject.models.User;
import com.mandana.firstspringbootproject.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> addUser(User user) {
        userRepository.save(user);
        return getUsers();
    }
}
