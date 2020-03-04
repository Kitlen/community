package life.majiang.community.exception;

/**
 * kilten All rights reserved.
 * <p>
 * Author: kilten
 * Version: 1.0
 * Created Time: 2020-2-19
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2020-2-19		kilten			Create file
 * =========================================================================
 */

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND(2001,"问题不存在，刷新页面试试哦"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NOT_LOGIN(2003,"当前操作需登录，请登录后重试"),
    SYSTEM_ERROR(2004,"服务器冒烟了，要不然你稍后再试试！"),
    TYPE_PARAM_ERROR(2005,"评论类型错误或者不存在"),
    COMMENT_NOT_FOUND(2006,"评论不存在");

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
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
