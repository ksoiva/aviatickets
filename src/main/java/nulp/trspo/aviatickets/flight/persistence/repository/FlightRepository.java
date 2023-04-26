package nulp.trspo.aviatickets.flight.persistence.repository;

import nulp.trspo.aviatickets.flight.persistence.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

}
