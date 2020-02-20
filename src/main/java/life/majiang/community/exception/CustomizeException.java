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

public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(String message) {
        this.message = message;
    }

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
