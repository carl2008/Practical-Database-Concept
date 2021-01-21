package com.rmit.Practical_Database_Concept;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebMVCController {
    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", model);
        return "index";
    }

    @GetMapping("/movie")
    public String getSubPage() {
        return "movie/index";
    }
}
