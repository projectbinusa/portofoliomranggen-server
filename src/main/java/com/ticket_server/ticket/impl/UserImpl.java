package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.UserDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserImpl {
    private final List<UserDTO> users = new ArrayList<>();

    public List<UserDTO> getAllUsers() {
        return users;
    }

    public Optional<UserDTO> getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public void addUser(UserDTO user) {
        users.add(user);
    }

    public boolean updateUser(Long id, UserDTO updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.set(i, updatedUser);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}
