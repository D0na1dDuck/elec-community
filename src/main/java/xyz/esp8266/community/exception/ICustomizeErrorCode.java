package xyz.esp8266.community.exception;

// 自定义接口基础类
public interface ICustomizeErrorCode {
    // 错误描述
    String getMessage();
    // 错误码
    Integer getCode();
}