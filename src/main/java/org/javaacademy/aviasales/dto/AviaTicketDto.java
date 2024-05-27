package org.javaacademy.aviasales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AviaTicketDto {
    private UUID id;
    private String cityTo;
    private String cityFrom;
    private LocalDate date;
    private BigDecimal price;
}
