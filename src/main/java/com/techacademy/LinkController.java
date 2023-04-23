package com.techacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkController {

    @GetMapping("/link")
    public String getLink(Model model) {
        model.addAttribute("id", "123");
        return "link";
    }
}