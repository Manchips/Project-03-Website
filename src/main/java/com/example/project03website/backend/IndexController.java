package com.example.project03website.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    public static final String BASE_URI = "http://localhost:9090/api/";

    User loggedInUser;

    @GetMapping("/")
    public String landingPage(Model model) {
        return "index";
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

        return"homeSearch";
    }

    @GetMapping("/login")
    String login(Model model){
        return "login";
    }

    @RequestMapping("/homeSearch")
    String home(Model model){
        // Authenticated User Object
//        List<User> listUsers = (List<User>) userRepository.findAll();




        return "homeSearch";
    }
}
