package com.ticket_server.ticket.impl;

import com.ticket_server.ticket.model.Inventaris;
import com.ticket_server.ticket.repository.InventarisRepository;
import com.ticket_server.ticket.service.InventarisService;
import org.springframework.stereotype.Service;

@Service
public class InventarisImpl extends InventarisService {

    public InventarisImpl(InventarisRepository inventarisRepository) {
        super(inventarisRepository);
    }
}
