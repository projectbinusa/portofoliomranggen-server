package com.ticket_server.ticket.DTO;

import com.ticket_server.ticket.model.Notification;

import java.time.LocalDateTime;

public class NotificationDTO {
    private Long id;
    private String message;
    private String type;
    private LocalDateTime time;

    public NotificationDTO() {}

    public NotificationDTO(Notification notification) {
        this.id = notification.getId();
        this.message = notification.getMessage();
        this.type = notification.getType();
        this.time = notification.getTime();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }
}
