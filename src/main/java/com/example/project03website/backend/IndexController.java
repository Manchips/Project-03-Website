package com.example.project03website.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String landingPage(Model model) {
        return "landingpage";
    }
    @GetMapping("/register")
    String register(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return "SignUpPage";
    }
    @PostMapping("/register")
    String registerSubmit(@ModelAttribute("user") User user){
        userRepository.save(user);

        return"landingPage";
    }

    @GetMapping("/login")
    String login(Model model){
        return "login";
    }


}
