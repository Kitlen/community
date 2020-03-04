package life.majiang.community.controller;

import life.majiang.community.dto.CommentDto;
import life.majiang.community.exception.CustomizeErrorCode;
import life.majiang.community.exception.CustomizeException;
import life.majiang.community.model.User;
import life.majiang.community.result.ResultBody;
import life.majiang.community.service.CommentService;
import life.majiang.community.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @PostMapping("/comment")
    public ResultBody post(@RequestBody CommentDto dto, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            throw new CustomizeException(CustomizeErrorCode.NOT_LOGIN);
        }
        commentService.insert(dto, request);

        return ResultUtils.success();
    }
}
