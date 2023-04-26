package nulp.trspo.aviatickets.ticket.api.rest;

import lombok.RequiredArgsConstructor;
import nulp.trspo.aviatickets.api.TicketApiDelegate;
import nulp.trspo.aviatickets.model.TicketDto;
import nulp.trspo.aviatickets.ticket.domain.service.TicketService;
import nulp.trspo.aviatickets.ticket.mapping.TicketMapper;
import nulp.trspo.aviatickets.ticket.persistence.entity.TicketEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TicketApiDelegateImpl implements TicketApiDelegate {
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;
    @Override
    public ResponseEntity<TicketDto> addTicket(TicketDto ticketDto) {
        TicketEntity ticketEntity = ticketMapper.ticketDtoToTicket(ticketDto);
        TicketDto savedTicket = ticketMapper.ticketToTicketDto(ticketService.addTicket(ticketEntity));
        return ResponseEntity.ok(savedTicket);
    }

    @Override
    public ResponseEntity<Void> deleteTicketById(BigDecimal ticketId) {
        ticketService.deleteTicketById(ticketId.longValue());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<TicketDto> getTicketById(BigDecimal ticketId) {
        return ticketService.getTicketById(ticketId.longValue())
                .map(ticket -> ResponseEntity.ok(ticketMapper.ticketToTicketDto(ticket)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<TicketDto> updateTicketById(BigDecimal ticketId, TicketDto ticketDto) {
        TicketEntity ticketEntity = ticketMapper.ticketDtoToTicket(ticketDto);
        TicketDto updatedTicket = ticketMapper.ticketToTicketDto(ticketService.updateTicketById(ticketId.longValue(), ticketEntity));
        return ResponseEntity.ok(updatedTicket);
    }
}
