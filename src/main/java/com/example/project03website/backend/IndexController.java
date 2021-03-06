package com.example.project03website.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {

    @Autowired
    Api api;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SheetRepository sheetRepository;
    @Autowired
    private UserSheetsRepository userSheetsRepository;
    @Autowired
    private SavedSheetRepository savedSheetRepository;

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
  
//    @GetMapping("/displayUserSheet")
//    String displaySheet(@RequestParam Integer sheetId, @RequestParam Integer userId, Model model){
//        Sheet sheet = api.getSheetId(sheetId);
//        return "UserSheet";
//    }

    @GetMapping("/displayUserSheet")
    public ModelAndView displaySheet(@RequestParam(defaultValue = "6") Integer sheetId){
        ModelAndView mav = new ModelAndView("UserSheet");
        mav.addObject("userSheet",sheetRepository.findDistinctBySheetId(sheetId));
        return mav;
    }

}
