package life.majiang.community.controller;

import life.majiang.community.dto.PaginationDTO;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * 根目录
     * @return
     */
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name="id" ) Long id,
                        Model model) {
        QuestionDTO questionDTO = questionService.getById(id);
        //累计阅读数
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
