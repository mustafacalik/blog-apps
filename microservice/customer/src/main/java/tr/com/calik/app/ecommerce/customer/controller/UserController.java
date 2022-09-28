package tr.com.calik.app.ecommerce.customer.controller;

import org.jboss.logging.Logger;
import tr.com.calik.app.ecommerce.customer.api.BaseResponseModel;
import tr.com.calik.app.ecommerce.customer.api.ErrorType;
import tr.com.calik.app.ecommerce.customer.api.dto.UserDto;
import tr.com.calik.app.ecommerce.customer.model.User;
import tr.com.calik.app.ecommerce.customer.service.UserException;
import tr.com.calik.app.ecommerce.customer.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api/users")
@Produces(APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @Inject
    Logger logger;

    @GET
    @Path("/{email}")
    public Response getUser(String email) throws UserException {
        Optional<User> user = userService.findByEmail(email);
        return Response.ok(BaseResponseModel.success(user.orElseThrow(() -> new UserException(ErrorType.NOT_FOUND)))).build();
    }

    @POST
    public Response createUser(UserDto userDto) throws UserException {
        userService.createUser(userDto);
        logger.debug("Create user " + userDto);
        return Response.ok().build();
    }


}
