package life.majiang.community.advise;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import life.majiang.community.exception.CustomizeErrorCode;
import life.majiang.community.exception.CustomizeException;
import life.majiang.community.result.ResultBody;
import life.majiang.community.utils.ResultUtils;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
@ControllerAdvice(basePackages = "life.majiang.community.controller")
//@ControllerAdvice
@ResponseBody
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    Object handleControllerException(HttpServletRequest request, Throwable ex, Model model, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        String contentType = request.getContentType();
        ResultBody error = null;
        if ("application/json".equals(contentType)) {
            //返回json结构
            if (ex instanceof CustomizeException) {
                error = ResultUtils.error((CustomizeException) ex);
            } else {
                error = ResultUtils.error(CustomizeErrorCode.SYSTEM_ERROR);
            }
            //使用writer或者是使用responseBody
            /*PrintWriter writer = null;
            try {
                response.setContentType("application/json");
                response.setStatus(HttpStatus.OK.value());
                response.setCharacterEncoding("UTF-8");
                writer = response.getWriter();
                writer.write(JSON.toJSONString(error));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            return error;
        } else {
            //返回modelAndView结构
            if (ex instanceof CustomizeException) {
                model.addAttribute("message", ex.getMessage());
            } else {
                model.addAttribute("message", "服务器冒烟了，等一下再来试试吧！~");
            }
            return new ModelAndView("error");
        }
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
