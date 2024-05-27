package org.javaacademy.aviasales.mapper;

import org.javaacademy.aviasales.dto.AviaTicketDto;
import org.javaacademy.aviasales.entity.AviaTicket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AviaTicketMapper {

    AviaTicketDto convertToDto(AviaTicket entity);
    @Mapping(target = "id", ignore = true)
    AviaTicket convertToEntity(AviaTicketDto dto);
}
