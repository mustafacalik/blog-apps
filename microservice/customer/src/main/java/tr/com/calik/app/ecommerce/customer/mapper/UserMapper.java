package tr.com.calik.app.ecommerce.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import tr.com.calik.app.ecommerce.customer.api.dto.UserDto;
import tr.com.calik.app.ecommerce.customer.model.User;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class UserMapper {

    public abstract UserDto toDto(User user);

    public abstract User fromDto(UserDto user);

}
