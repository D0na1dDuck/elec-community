package xyz.esp8266.community.exception;

// 自定义异常类，继承 RuntimeException,由 service 层直接抛出，交给全局异常处理器，不用向上交给 control 层处理。
public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;
    public CustomizeException(ICustomizeErrorCode errorCode){
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }
    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() { return code; }
}
