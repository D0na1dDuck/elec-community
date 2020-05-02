package xyz.esp8266.community.exception;

public enum CustomizeErrorCode implements iCustomizeErrorCode{
    QUESTION_NOT_FOUND("你找的问题不存在！");
    private String message;
    CustomizeErrorCode(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}