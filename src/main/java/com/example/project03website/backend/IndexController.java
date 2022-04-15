package com.example.project03website.backend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String landingPage(Model model) {
        return "landingpage";
    }
    @GetMapping("/home")
    String home(Model model){

        return "home";
    }

}
