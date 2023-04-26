package nulp.trspo.aviatickets.ticket.mapping;

import nulp.trspo.aviatickets.flight.mapping.FlightMapper;
import nulp.trspo.aviatickets.model.TicketDto;
import nulp.trspo.aviatickets.ticket.persistence.entity.TicketEntity;
import nulp.trspo.aviatickets.user.mapping.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {FlightMapper.class, UserMapper.class})
public interface TicketMapper {

    TicketDto ticketToTicketDto (TicketEntity ticket);
    TicketEntity ticketDtoToTicket (TicketDto ticketDto);
}
