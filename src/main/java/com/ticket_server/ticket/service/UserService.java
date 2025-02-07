package com.ticket_server.ticket.service;

import com.ticket_server.ticket.model.User;
import com.ticket_server.ticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User tambahUser(User user) {
        if (user.getAdminId() == null) {
            throw new IllegalArgumentException("Admin ID harus dimasukkan");
        }
        return userRepository.save(user);
    }

    public User editUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setAdminId(updatedUser.getAdminId());
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        }).orElse(null);
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
