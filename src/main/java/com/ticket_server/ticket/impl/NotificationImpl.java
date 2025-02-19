package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.DTO.NotificationDTO;
import com.ticket_server.ticket.model.Notification;
import com.ticket_server.ticket.repository.NotificationRepository;
import com.ticket_server.ticket.service.NotificationService;
import com.ticket_server.ticket.service.NotificationWebSocketService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationWebSocketService notificationWebSocketService;

    public NotificationImpl(NotificationRepository notificationRepository, NotificationWebSocketService notificationWebSocketService) {
        this.notificationRepository = notificationRepository;
        this.notificationWebSocketService = notificationWebSocketService;
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

        // Kirim notifikasi real-time ke semua pengguna
        notificationWebSocketService.sendNotification(savedDTO);

        return savedDTO;
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
