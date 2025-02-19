package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.NotificationDTO;
import com.ticket_server.ticket.model.Notification;
import com.ticket_server.ticket.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<NotificationDTO> getNotificationById(@PathVariable Long id) {
        Optional<Notification> notification = notificationService.getNotificationById(id);
        return notification.map(notif -> ResponseEntity.ok(new NotificationDTO(notif)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<NotificationDTO> addNotification(@RequestBody NotificationDTO notificationDTO) {
        return ResponseEntity.ok(notificationService.addNotification(notificationDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}
