package life.majiang.community.utils;

import life.majiang.community.exception.CustomizeErrorCode;
import life.majiang.community.exception.CustomizeException;
import life.majiang.community.result.ResultBody;
import org.springframework.http.HttpStatus;

/**
 * kitlen All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2020-3-1
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2020-3-1		kitlen			Create file
 * =========================================================================
 */

public class ResultUtils {
    public static ResultBody success() {
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(HttpStatus.OK.value());
        resultBody.setMessage("成功");
        return resultBody;
    }


    /**
     * 错误
     *
     * @param code
     * @param message
     * @return
     */
    public static ResultBody error(Integer code, String message) {
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(code);
        resultBody.setMessage(message);
        return resultBody;
    }

    /**
     * CustomizeErrorCode 错误
     *
     * @param error
     * @return
     */
    public static ResultBody error(CustomizeErrorCode error) {
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(error.getCode());
        resultBody.setMessage(error.getMessage());
        return resultBody;
    }

    /**
     * 自定义异常
     * @param e
     * @return
     */
    public static ResultBody error(CustomizeException e) {
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

}
