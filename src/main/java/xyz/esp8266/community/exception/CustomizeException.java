package xyz.esp8266.community.exception;

public class CustomizeException extends RuntimeException {
    private String message;
    public CustomizeException(iCustomizeErrorCode errorCode){
        this.message = errorCode.getMessage();
    }
    @Override
    public String getMessage() {
        return message;
    }
}
