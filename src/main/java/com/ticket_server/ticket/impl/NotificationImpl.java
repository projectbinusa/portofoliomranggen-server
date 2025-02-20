package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.NotificationDTO;
import com.ticket_server.ticket.model.Notification;
import com.ticket_server.ticket.repository.NotificationRepository;
import com.ticket_server.ticket.service.NotificationService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final SimpMessagingTemplate messagingTemplate; // ✅ Gunakan langsung SimpMessagingTemplate

    public NotificationImpl(NotificationRepository notificationRepository, SimpMessagingTemplate messagingTemplate) {
        this.notificationRepository = notificationRepository;
        this.messagingTemplate = messagingTemplate; // ✅ Inject SimpMessagingTemplate langsung
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    public NotificationDTO addNotification(NotificationDTO notificationDTO) {
        notificationDTO.setTime(LocalDateTime.now());
        Notification notification = new Notification(notificationDTO);
        Notification savedNotification = notificationRepository.save(notification);
        NotificationDTO savedDTO = new NotificationDTO(savedNotification);

        // ✅ Kirim notifikasi real-time ke semua pengguna lewat WebSocket
        messagingTemplate.convertAndSend("/topic/notifications", savedDTO);

        return savedDTO;
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
