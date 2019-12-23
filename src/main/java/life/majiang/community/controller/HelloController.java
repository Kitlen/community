package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
 * =========================================================================
 */
@Controller
public class HelloController {

    /**
     * 故意做个修改
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/hello")
    public String greeting(@RequestParam(name="name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
