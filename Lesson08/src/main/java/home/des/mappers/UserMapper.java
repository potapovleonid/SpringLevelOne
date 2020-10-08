package home.des.mappers;

import home.des.domain.User;
import home.des.dto.UserDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User toUser (UserDTO dto);

    @InheritInverseConfiguration
    UserDTO fromUser(User user);

    List<User> toUserList(List<UserDTO> userDTOS);

    List<UserDTO> fromUserList(List<User> users);

}
