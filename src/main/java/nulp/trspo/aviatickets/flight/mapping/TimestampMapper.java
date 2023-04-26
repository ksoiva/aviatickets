package nulp.trspo.aviatickets.flight.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TimestampMapper {
    default Timestamp offSetToTimestamp(OffsetDateTime offsetDateTime){
        return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
    }
    default OffsetDateTime timestampToOffSet(Timestamp timestamp){
        return OffsetDateTime.ofInstant(Instant.ofEpochMilli(timestamp.getTime()), ZoneId.systemDefault());
    }
}
