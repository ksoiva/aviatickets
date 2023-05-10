package nulp.trspo.aviatickets.ticket.domain.service;

import lombok.RequiredArgsConstructor;
import nulp.trspo.aviatickets.flight.domain.service.FlightService;
import nulp.trspo.aviatickets.flight.persistence.entity.FlightEntity;
import nulp.trspo.aviatickets.flight.persistence.entity.PlaneEntity;
import nulp.trspo.aviatickets.ticket.dictionary.Services;
import nulp.trspo.aviatickets.ticket.persistence.entity.TicketEntity;
import nulp.trspo.aviatickets.ticket.persistence.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final FlightService flightService;

    public TicketEntity addTicket(TicketEntity ticket) {
        FlightEntity flight = ticket.getFlight();
        ticket.setFlight(flightService.getFlightById(flight.getId()));
        calcTotalPrice(ticket);
        calcSeat(ticket);

        return ticketRepository.save(ticket);
    }

    private void calcTotalPrice(TicketEntity ticket) {
        Float totalPrice = ticket.getFlight().getPrice();
        if (ticket.getBaggage()) {
            totalPrice += Services.BAGGAGE.getValue();
        }
        if (ticket.getPriority()) {
            totalPrice += Services.PRIORITY.getValue();
        }
        ticket.setTotalPrice(totalPrice);
    }

    private void calcSeat(TicketEntity ticket) {
        PlaneEntity plane = ticket.getFlight().getPlane();
        int availableSeats = ticket.getFlight().getAvailableSeats();

        int seatsPerRow = plane.getSeatCount() / plane.getRowCount();
        int occupiedSeats = Math.floorMod(availableSeats, seatsPerRow);
        char seatChar = (char) (65 + seatsPerRow - (occupiedSeats == 0 ? seatsPerRow : occupiedSeats));
        int row = plane.getRowCount() - (int) Math.ceil((double) availableSeats / seatsPerRow) + 1;
        ticket.setFlight(flightService.decreaseAvailableSeats(ticket.getFlight().getId()));
        ticket.setSeat(Integer.toString(row) + seatChar);
    }

    public void deleteTicketById(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    public Optional<TicketEntity> getTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId);
    }

    public TicketEntity updateTicketById(Long ticketId, TicketEntity newTicket) {
        newTicket.setId(ticketId);
        return ticketRepository.save(newTicket);
    }
}
