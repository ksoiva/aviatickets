package nulp.trspo.aviatickets.flight.domain.service;

import lombok.RequiredArgsConstructor;
import nulp.trspo.aviatickets.flight.persistence.entity.FlightEntity;
import nulp.trspo.aviatickets.flight.persistence.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightEntity addFlight(FlightEntity flight){
        return flightRepository.save(flight);
    }

    public void deleteFlightById(Long flightId){
        flightRepository.deleteById(flightId);
    }

    public List<FlightEntity> getFlights(){
        return flightRepository.findAll();
    }

    public Optional<FlightEntity> getFlightById(Long flightId){
        return flightRepository.findById(flightId);
    }

    public FlightEntity updateFlightById(Long flightId, FlightEntity newFlight){
        newFlight.setId(flightId);
        return flightRepository.save(newFlight);
    }

}
