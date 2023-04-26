package nulp.trspo.aviatickets.ticket.domain.service;

import lombok.RequiredArgsConstructor;
import nulp.trspo.aviatickets.ticket.persistence.entity.TicketEntity;
import nulp.trspo.aviatickets.ticket.persistence.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
     private final TicketRepository ticketRepository;

     public TicketEntity addTicket(TicketEntity ticket){
         return ticketRepository.save(ticket);
     }

     public void deleteTicketById(Long ticketId){
         ticketRepository.deleteById(ticketId);
     }

     public Optional<TicketEntity> getTicketById(Long ticketId){
         return ticketRepository.findById(ticketId);
     }

     public TicketEntity updateTicketById(Long ticketId, TicketEntity newTicket){
         newTicket.setId(ticketId);
         return ticketRepository.save(newTicket);
     }
}
