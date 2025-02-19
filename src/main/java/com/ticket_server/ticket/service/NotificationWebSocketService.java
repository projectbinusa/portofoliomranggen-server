package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.NotificationDTO;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationWebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificationWebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendNotification(NotificationDTO notification) {
        messagingTemplate.convertAndSend("/topic/notifications", notification);
    }
}
