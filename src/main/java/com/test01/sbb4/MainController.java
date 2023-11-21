package com.test01.sbb4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/sbb4")
    @ResponseBody
    public String init() {
        return "안녕하세요";
    }
    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
