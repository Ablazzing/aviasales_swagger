package org.javaacademy.aviasales.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.javaacademy.aviasales.dto.AviaTicketDto;
import org.javaacademy.aviasales.service.AviaTicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/ticket")
@RequiredArgsConstructor
@Tag(name = "Работа с билетами V1", description = "Методы по работе с билетами")
public class AviaTicketsControllerV1 {
    private final AviaTicketService aviaTicketService;

    @GetMapping("/date-filter")
    @Operation( summary = "Поиск билетов по дате (из города в город)")
    @ApiResponse(responseCode = "200",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AviaTicketDto.class)))
    public ResponseEntity<?> findTicketByDate(
            @RequestParam @Parameter(description = "Дата полета") LocalDate flyDate,
                                              @RequestParam @Parameter(description = "Город вылета") String cityFrom,
                                              @RequestParam @Parameter(description = "Город прилета") String cityTo) {
        return ResponseEntity.ok(aviaTicketService.getTicketsByDateAndCityToAndCityFrom(flyDate, cityFrom, cityTo));
    }

    @PostMapping
    @Operation(summary = "Создание билета")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<?> createTicket(AviaTicketDto dto) {
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/date")
    @Operation(summary = "Удаление билетов по дате")
    @ApiResponse(responseCode = "202")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Удаление успешно"),
            @ApiResponse(responseCode = "400", description = "Неверный формат даты")
    })
    public ResponseEntity<?> deleteTicketsByDate(
            @RequestParam("date") @Parameter(description = "Дата билета", example = "2088-11-11") LocalDate date) {
        aviaTicketService.deleteTicketsByDate(date);
        return ResponseEntity.accepted().build();
    }
}
