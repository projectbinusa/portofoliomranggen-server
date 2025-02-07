package com.ticket_server.ticket.DTO;

public class UserDTO {
    private Long adminId;
    private Long id;
    private String username;
    private String email;
    private String password;

    public UserDTO() {}

    public UserDTO(Long adminId, Long id, String username, String email, String password) {
        this.adminId = adminId;
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}