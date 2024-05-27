package org.javaacademy.aviasales.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.javaacademy.aviasales.dto.AviaTicketDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

import static java.math.BigDecimal.TEN;

@Service
@Profile("init-ticket")
@RequiredArgsConstructor
public class InitDataService {
    private final AviaTicketService aviaTicketService;

    @PostConstruct
    public void init() {
        String cityTo = "Moscow";
        String cityFrom = "Leningrad";
        AtomicReference<LocalDate> atomicDate = new AtomicReference<>(LocalDate.now());
        IntStream.range(0, 10)
                .forEach(e -> {
                    aviaTicketService.createTicket(createDto(cityFrom, cityTo, atomicDate.get()));
                    atomicDate.set(atomicDate.get().plus(1, ChronoUnit.DAYS));
                });
    }

    private AviaTicketDto createDto(String cityFrom, String cityTo, LocalDate date) {
        return new AviaTicketDto(null, cityTo, cityFrom, date, TEN);
    }
}
