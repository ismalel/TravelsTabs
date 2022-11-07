package com.encora.travelstab.service.impl;

import com.encora.travelstab.exception.BadRequestException;
import com.encora.travelstab.exception.ResourceNotFoundException;
import com.encora.travelstab.http.ApiResponse;
import com.encora.travelstab.model.User;
import com.encora.travelstab.repository.UserRepository;
import com.encora.travelstab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Email is already taken");
            throw new BadRequestException(apiResponse);
        }

        return userRepository.save(user);
    }

    @Override
    public User read(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }

    @Override
    public ApiResponse delete(User currentUser) {
        User user = userRepository.findByEmail(currentUser.getEmail()).orElseThrow(() -> new ResourceNotFoundException("User", "id", currentUser.getEmail()));

        userRepository.deleteById(user.getId());

        return new ApiResponse(Boolean.TRUE, "You successfully deleted user of: " + user.getId());
    }
}
