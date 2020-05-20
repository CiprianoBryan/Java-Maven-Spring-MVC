package academy.learnprogramming.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {
    // We´re always going to annotate our web controllers with the controller annotation

    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // http://localhost:8080/todo-list/welcome
    // prefix + name + suffix
    // /WEB-INF/view/welcome.jsp
    @GetMapping("welcome")
    public String welcome(Model model) {
        model.addAttribute("user", "Tim");
        log.info("model= {}", model);
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return "welcome to this Demo application";
    }
}
