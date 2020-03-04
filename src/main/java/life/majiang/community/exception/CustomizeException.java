package life.majiang.community.exception;

import com.sun.org.apache.bcel.internal.classfile.Code;

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
    private Integer code;
    private String message;


    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
