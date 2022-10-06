package tr.com.calik.app.ecommerce.customer.api;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpStatusClass;
import org.eclipse.microprofile.config.ConfigProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseResponseModel<T> {

    public String status = "SUCCESS";
    public Integer statusCode = 200;
    public Boolean isSuccess = Boolean.TRUE;
    public List<ErrorModel> errors = new ArrayList<>();
    public T response;

    public String env = "";

    public BaseResponseModel(T response) {
        this.response = response;
    }

    public static BaseResponseModel<?> success(Object response){
        BaseResponseModel<?> responseModel = new BaseResponseModel<>(response);
        responseModel.status = HttpResponseStatus.OK.reasonPhrase();
        responseModel.statusCode = HttpResponseStatus.OK.code();
        responseModel.isSuccess = Boolean.TRUE;
        responseModel.env = getHostInfo();
        return responseModel;
    }

    public static BaseResponseModel<?> fail(Object response, HttpResponseStatus httpResponseStatus, List<ErrorModel> errors){
        BaseResponseModel<?> responseModel = new BaseResponseModel<>(response);
        responseModel.status = httpResponseStatus.reasonPhrase();
        responseModel.statusCode = httpResponseStatus.code();
        responseModel.errors = errors;
        responseModel.isSuccess = Boolean.FALSE;
        responseModel.env = getHostInfo();
        return responseModel;
    }

    private static String getHostInfo(){
        Optional<String> hostname = ConfigProvider.getConfig().getOptionalValue("HOSTNAME", String.class);
        Optional<String> port = ConfigProvider.getConfig().getOptionalValue("quarkus.http.port", String.class);
        return System.currentTimeMillis() + "-->" + hostname.orElse("NO_HOST") + ":" + port.orElse("NO_PORT");
    }
}
