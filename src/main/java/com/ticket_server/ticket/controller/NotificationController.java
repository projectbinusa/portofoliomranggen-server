package com.ticket_server.ticket.controller;

import com.ticket_server.ticket.DTO.NotificationDTO;
import com.ticket_server.ticket.model.Notification;
import com.ticket_server.ticket.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    private final NotificationService notificationService;
    private final SimpMessagingTemplate messagingTemplate; // 🔥 Tambahkan WebSocket template

    public NotificationController(NotificationService notificationService, SimpMessagingTemplate messagingTemplate) {
        this.notificationService = notificationService;
        this.messagingTemplate = messagingTemplate;
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
        NotificationDTO savedNotification = notificationService.addNotification(notificationDTO);

        // 🔥 Kirim notifikasi ke WebSocket setelah ditambahkan
        messagingTemplate.convertAndSend("/topic/notifications", savedNotification);
        System.out.println("📢 Notifikasi dikirim ke WebSocket: " + savedNotification.getMessage());

        return ResponseEntity.ok(savedNotification);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}
