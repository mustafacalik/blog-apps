package tr.com.calik.app.ecommerce.customer.service.impl;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tr.com.calik.app.ecommerce.customer.api.dto.UserDto;
import tr.com.calik.app.ecommerce.customer.mapper.UserMapper;
import tr.com.calik.app.ecommerce.customer.model.User;
import tr.com.calik.app.ecommerce.customer.repository.UserRepository;
import tr.com.calik.app.ecommerce.customer.service.UserException;
import tr.com.calik.app.ecommerce.customer.service.UserService;

import javax.inject.Inject;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class UserServiceImplTest {

    @Inject
    private UserService userService;

    @InjectMock
    private UserMapper userMapper;

    @InjectMock
    private UserRepository userRepository;

    @Test
    void Should_CreateUser_When_UserDtoAsParameter() throws UserException {
        //Given
        UserDto userDto = createUserDto("name","surname","mymail@mail.com");
        User expectedUser = createUserEntity(userDto);
        ObjectId expectedUserId = new ObjectId();
        Mockito.when(userRepository.findByEmail(userDto.email)).thenReturn(Optional.empty());
        Mockito.when(userMapper.fromDto(userDto)).thenReturn(expectedUser);
        Mockito.doAnswer(invocationOnMock -> expectedUser.id = expectedUserId).when(userRepository).persist(expectedUser);

        //When
        String actualUserId = userService.createUser(userDto);

        //Then
        assertEquals(expectedUserId.toString(), actualUserId);
    }

    @Test
    void Should_ThrowException_When_ExistingUserAsParameter() throws UserException {
        UserDto userDto = createUserDto("name","surname","mymail@mail.com");
        Mockito.when(userRepository.findByEmail(userDto.email)).thenReturn(Optional.of(createUserEntity(userDto)));

        UserException exception = assertThrows(UserException.class, () -> {
            userService.createUser(userDto);
        });

        assertTrue(exception.getMessage().contains("User was already created"));
    }

    private UserDto createUserDto(String firstName, String lastName, String email){
        UserDto userDto = new UserDto();
        userDto.firstName = firstName;
        userDto.lastName = lastName;
        userDto.email = email;
        return userDto;
    }

    private User createUserEntity(UserDto userDto){
        User user = new User();
        user.firstName = userDto.firstName;
        user.lastName = userDto.lastName;
        user.email = userDto.email;
        return user;
    }


}
