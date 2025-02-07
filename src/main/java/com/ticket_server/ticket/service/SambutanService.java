package com.ticket_server.ticket.service;

import com.ticket_server.ticket.DTO.SambutanDTO;
import com.ticket_server.ticket.model.Sambutan;

import java.util.List;
import java.util.Optional;

public interface SambutanService {

    List<Sambutan> getAllSambutan();

    Optional<Sambutan> getSambutanById(Long id);

    SambutanDTO tambahSambutan(SambutanDTO sambutanDTO);

    SambutanDTO editSambutan(Long id, SambutanDTO sambutanDTO);

    void deleteSambutan(Long id);
}
