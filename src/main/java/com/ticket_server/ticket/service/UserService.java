package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.PasswordDTO;
import com.ticket_server.ticket.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User registerUser(User user);

    User getById(Long id);

    List<User> getAll();

    User edit(Long id, User user);

    User putPasswordUser(PasswordDTO passwordDTO, Long id);

    Map<String, Boolean> delete(Long id);
}
