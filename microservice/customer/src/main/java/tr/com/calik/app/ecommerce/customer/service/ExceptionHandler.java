package tr.com.calik.app.ecommerce.customer.service;

import io.netty.handler.codec.http.HttpResponseStatus;
import tr.com.calik.app.ecommerce.customer.api.BaseResponseModel;
import tr.com.calik.app.ecommerce.customer.api.ErrorModel;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Arrays;

@Provider
public class ExceptionHandler
        implements ExceptionMapper<UserException> {

    //@ConfigProperty(name = "knowledgefactory.custom.error.msg.usernotfound")
    //String userNotFound;

    @Override
    public Response toResponse(UserException e) {
        return Response.status(Response.Status.BAD_REQUEST).
                entity(BaseResponseModel.fail(null, HttpResponseStatus.BAD_REQUEST, Arrays.asList(new ErrorModel(e.errorType, e.getMessage()))))
                .build();
    }
}
