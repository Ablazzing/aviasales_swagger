package org.javaacademy.aviasales.repository;

import org.javaacademy.aviasales.entity.AviaTicket;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AviaTicketRepository {
    private HashMap<UUID, AviaTicket> data = new HashMap<UUID, AviaTicket>();

    public List<AviaTicket> findTicketsByDateAndCityToAndCityFrom(LocalDate date, String cityTo, String cityFrom) {
        return data.values().stream()
                .filter(e -> e.getCityTo().equals(cityTo)
                             && e.getCityFrom().equals(cityFrom)
                             && e.getDate().equals(date))
                .toList();
    }

    public AviaTicket findByKey(UUID key) {
        return Optional.ofNullable(data.get(key)).orElseThrow();
    }

    public void createTicket(AviaTicket entity) {
        if (data.containsKey(entity.getId())) {
            throw new RuntimeException("Ticket already exists");
        }
        entity.setId(UUID.randomUUID());
        data.put(entity.getId(), entity);
    }

    public void deleteTicketsByDate(LocalDate ticketDate) {
        data = data.values().stream()
                .filter(e -> !Objects.equals(e.getDate(), ticketDate))
                .collect(Collectors.toMap(AviaTicket::getId, e -> e, (a, b) -> a, HashMap::new));
    }

    public List<AviaTicket> findAll() {
        return data.values().stream().toList();
    }

//    public boolean deleteByKey(UUID key) {
//
//    }
}
