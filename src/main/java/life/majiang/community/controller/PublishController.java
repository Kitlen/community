package life.majiang.community.controller;

import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionService questionService;

    /**
     * 进入发布页面
     * @return
     */
    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    /**
     * 发布问题
     * @param title
     * @param description
     * @param id
     * @param tag
     * @param request
     * @param model
     * @return
     */
    @PostMapping("/publish")
    public String doPublish(@RequestParam("title") String title, @RequestParam("description") String description,
            @RequestParam("id") Long id,
            @RequestParam("tag") String tag,
            HttpServletRequest request,Model model) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        if (StringUtils.isEmpty(title)) {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (StringUtils.isEmpty(description)) {
            model.addAttribute("error", "内容不能为空");
            return "publish";
        }
        if (StringUtils.isEmpty(tag)) {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }

        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }

        Question question = new Question();
        question.setId(id);
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        questionService.createOrUpdate(question);
//        questionMapper.create(question);
        return "redirect:/";

    }

    /**
     * 编辑问题
     * @param id
     * @return
     */
    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name="id")Long id,Model model) {
        QuestionDTO question = questionService.getById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());
        model.addAttribute("id",question.getId());
        return "publish";
    }
}
