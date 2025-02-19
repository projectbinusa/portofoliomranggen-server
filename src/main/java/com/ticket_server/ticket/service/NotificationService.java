package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.NotificationDTO;
import com.ticket_server.ticket.model.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    List<Notification> getAllNotifications();
    Optional<Notification> getNotificationById(Long id);
    NotificationDTO addNotification(NotificationDTO notificationDTO);
    void deleteNotification(Long id);
}
