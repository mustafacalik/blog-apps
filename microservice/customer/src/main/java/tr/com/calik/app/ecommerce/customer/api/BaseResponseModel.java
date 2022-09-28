package tr.com.calik.app.ecommerce.customer.api;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpStatusClass;

import java.util.ArrayList;
import java.util.List;

public class BaseResponseModel<T> {
    public String status = "SUCCESS";
    public Integer statusCode = 200;
    public Boolean isSuccess = Boolean.TRUE;
    public List<ErrorModel> errors = new ArrayList<>();
    public T response;

    public BaseResponseModel(T response) {
        this.response = response;
    }

    public static BaseResponseModel<?> success(Object response){
        BaseResponseModel<?> responseModel = new BaseResponseModel<>(response);
        responseModel.status = HttpResponseStatus.OK.reasonPhrase();
        responseModel.statusCode = HttpResponseStatus.OK.code();
        responseModel.isSuccess = Boolean.TRUE;
        return responseModel;
    }

    public static BaseResponseModel<?> fail(Object response, HttpResponseStatus httpResponseStatus, List<ErrorModel> errors){
        BaseResponseModel<?> responseModel = new BaseResponseModel<>(response);
        responseModel.status = httpResponseStatus.reasonPhrase();
        responseModel.statusCode = httpResponseStatus.code();
        responseModel.errors = errors;
        responseModel.isSuccess = Boolean.FALSE;
        return responseModel;
    }
}
