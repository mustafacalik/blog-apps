package tr.com.calik.app.ecommerce.customer.service;

import tr.com.calik.app.ecommerce.customer.api.dto.UserDto;
import tr.com.calik.app.ecommerce.customer.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);

    String createUser(UserDto userDto) throws UserException;
}
