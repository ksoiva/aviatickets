package nulp.trspo.aviatickets.flight.mapping;

import nulp.trspo.aviatickets.flight.persistence.entity.PlaneEntity;
import nulp.trspo.aviatickets.model.PlaneDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlaneMapper {

    PlaneDto planeToPlaneDto (PlaneEntity plane);
    PlaneEntity planeDtoToPlane (PlaneDto planeDto);
}
