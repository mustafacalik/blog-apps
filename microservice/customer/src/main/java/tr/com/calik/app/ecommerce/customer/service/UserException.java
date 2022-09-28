package tr.com.calik.app.ecommerce.customer.service;

import tr.com.calik.app.ecommerce.customer.api.ErrorType;

public class UserException extends Throwable {

    public ErrorType errorType;
    public UserException(ErrorType errorType, String exception) {
        super(exception);
        this.errorType = errorType;
    }

    public UserException(ErrorType errorType) {
        this.errorType = errorType;
    }
}
