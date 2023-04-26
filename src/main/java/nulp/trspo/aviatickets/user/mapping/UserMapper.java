package nulp.trspo.aviatickets.user.mapping;

import nulp.trspo.aviatickets.model.UserDto;
import nulp.trspo.aviatickets.user.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserMapper {

    UserDto userToUserDTO(UserEntity userEntity);
    UserEntity userDtoToUser(UserDto userDto);
}
