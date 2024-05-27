package org.javaacademy.aviasales.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AviaTicket {
    @NonNull
    private UUID id;
    @NonNull
    private String cityTo;
    @NonNull
    private String cityFrom;
    @NonNull
    private LocalDate date;
    @NonNull
    private BigDecimal price;
}
