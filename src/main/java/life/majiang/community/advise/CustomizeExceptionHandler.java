package life.majiang.community.advise;

import life.majiang.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * kitlen All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2020-2-19
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2020-2-19		kitlen			Create file
 * =========================================================================
 */
@ControllerAdvice(basePackages="life.majiang.community.controller")
//@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(HttpServletRequest request, Throwable ex, Model model) {
        HttpStatus status = getStatus(request);
        if (ex instanceof CustomizeException){
            model.addAttribute("message", ex.getMessage());
        } else {
            model.addAttribute("message", "服务器冒烟了，等一下再来试试吧！~");
        }
        return new ModelAndView("error");
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
