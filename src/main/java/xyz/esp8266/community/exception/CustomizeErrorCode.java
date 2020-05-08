package xyz.esp8266.community.exception;

// 自定义枚举类
public enum CustomizeErrorCode implements ICustomizeErrorCode{
    // 枚举值
    QUESTION_NOT_FOUND(2001, "您要找的问题不存在！"),
    TARGET_PARAM_NOT_FOUND(2002, "当前未选中任何问题或评论进行回复！请重试！"),
    SYS_ERROR(2004,"服务器炸了！稍后重试~"),
    NO_LOGIN(2003, "当前操作需要登录，请登录！"),
    TYPE_PARAM_NOT_FOUND(2005, "评论类型错误或不存在！"),
    COMMENT_NOT_FOUND(2006,"你要回复的评论不存在~" ),
    CONTENT_IS_EMPTY(2007,"评论内容不能为空！");
    // 错误描述
    private String message;
    //错误码
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}