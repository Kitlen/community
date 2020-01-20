package life.majiang.community.controller;

import life.majiang.community.dto.PaginationDTO;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * kitlen All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2019-12-20
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2019-12-20		kitlen			Create file
 * ==========================================================================
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    /**
     * 根目录
     * @return
     */
    @GetMapping("/")
    public String index(HttpServletRequest request,
                        @RequestParam(name="page" ,defaultValue = "1") Integer page,
                        @RequestParam(name="size",defaultValue = "2")Integer size,
                        Model model) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null ){
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    User user = userMapper.findByToken(cookie.getValue());
                    if(user != null ){
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        PaginationDTO paginationDTO = questionService.list(page, size);
        model.addAttribute("pagination",paginationDTO);
        return "index";
    }
}
