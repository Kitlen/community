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
    QUESTION_NOT_FOUND("问题不存在，刷新页面试试哦");

    private String message;
    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
