package tr.com.calik.app.ecommerce.customer.api;

public class ErrorModel {
    public ErrorType errorType;
    public String errorMessage;

    public ErrorModel(ErrorType errorType, String errorMessage) {
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }
}
