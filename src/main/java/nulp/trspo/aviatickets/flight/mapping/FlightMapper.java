package nulp.trspo.aviatickets.flight.mapping;

import nulp.trspo.aviatickets.flight.persistence.entity.FlightEntity;
import nulp.trspo.aviatickets.model.FlightDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PlaneMapper.class, TimestampMapper.class})
public interface FlightMapper {

    FlightDto flightToFlightDto(FlightEntity flight);
    FlightEntity flightDtoToFlight(FlightDto flightDto);
    List<FlightDto> entitiesToDTOs(List<FlightEntity> flightEntities);
}
