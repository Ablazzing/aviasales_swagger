package org.javaacademy.aviasales.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.aviasales.dto.AviaTicketDto;
import org.javaacademy.aviasales.entity.AviaTicket;
import org.javaacademy.aviasales.mapper.AviaTicketMapper;
import org.javaacademy.aviasales.repository.AviaTicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AviaTicketService {
    private final AviaTicketRepository repository;
    private final AviaTicketMapper mapper;

    public List<AviaTicketDto> getTicketsByDateAndCityToAndCityFrom(LocalDate date, String cityTo, String cityFrom) {
        return repository.findTicketsByDateAndCityToAndCityFrom(date, cityTo, cityFrom).stream()
                .map(mapper::convertToDto)
                .toList();
    }

    public AviaTicketDto getTicketByKey(UUID key) {
        return mapper.convertToDto(repository.findByKey(key));
    }

    public void createTicket(AviaTicketDto dto) {
        AviaTicket entity = mapper.convertToEntity(dto);
        repository.createTicket(entity);
    }

    public void deleteTicketsByDate(LocalDate ticketDate) {
        repository.deleteTicketsByDate(ticketDate);
    }
}
