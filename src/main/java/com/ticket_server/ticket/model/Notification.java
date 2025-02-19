package com.ticket_server.ticket.model;

import com.ticket_server.ticket.DTO.NotificationDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    public Notification() {}

    public Notification(NotificationDTO dto) {
        this.message = dto.getMessage();
        this.type = dto.getType();
        this.time = dto.getTime();
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
