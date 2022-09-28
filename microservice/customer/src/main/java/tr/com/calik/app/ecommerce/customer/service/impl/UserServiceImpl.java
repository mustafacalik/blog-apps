package tr.com.calik.app.ecommerce.customer.service.impl;

import tr.com.calik.app.ecommerce.customer.api.ErrorType;
import tr.com.calik.app.ecommerce.customer.api.dto.UserDto;
import tr.com.calik.app.ecommerce.customer.mapper.UserMapper;
import tr.com.calik.app.ecommerce.customer.model.User;
import tr.com.calik.app.ecommerce.customer.repository.UserRepository;
import tr.com.calik.app.ecommerce.customer.service.UserException;
import tr.com.calik.app.ecommerce.customer.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public String createUser(UserDto userDto) throws UserException {
        if(userRepository.findByEmail(userDto.email).isPresent()){
            throw new UserException(ErrorType.ALREADY_CREATED, "User was already created");
        }
        User user = userMapper.fromDto(userDto);
        userRepository.persist(user);
        return user.id.toString();
    }
}
