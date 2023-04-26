package nulp.trspo.aviatickets.ticket.persistence.repository;

import nulp.trspo.aviatickets.ticket.persistence.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}
