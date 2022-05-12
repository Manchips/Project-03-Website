package com.example.project03website.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api")
public class Api {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SavedSheetRepository savedSheetRepository;
    @Autowired
    private UserSheetsRepository userSheetsRepository;
    @Autowired
    private SheetRepository sheetRepository;

    @PostMapping(path="/addUser")
    public @ResponseBody String addUser (@RequestParam String username, @RequestParam String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return "saved";
    }

    @RequestMapping("/allUsers")
    String allUsers(Model model){

        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        return "allUsers";
    }

    @PostMapping (path="/deleteUser")
    public String deleteUser (@RequestParam Integer userId){
        User user = userRepository.findUserById(userId);
        userRepository.delete(user);
        return "redirect:/allUsers";
    }

    // find a sheet by there saved sheet Id
    @GetMapping(path = "/findBySavedSheetId")
    public @ResponseBody SavedSheets getSavedSheetId(@RequestParam Integer savedSheetId){
        return savedSheetRepository.findDistinctBySavedSheetId(savedSheetId);
    }

    // find a sheet by the sheet Id
    @GetMapping(path = "/findBySheetId")
    public @ResponseBody Sheet getSheetId(@RequestParam Integer sheetId){
        return sheetRepository.findDistinctBySheetId(sheetId);
    }

    // find a sheet by there user sheet Id
    @GetMapping(path = "/findByUserSheetsId")
    public @ResponseBody UserSheets getUserSheetsId(@RequestParam Integer userSheetsId){
        return userSheetsRepository.findDistinctByUserSheetsId(userSheetsId);
    }

    //display all sheets user has
    @GetMapping(path = "/allUserSheets")
    public @ResponseBody Iterable<UserSheets> getUserSheets(@RequestParam Integer userSheetsId){
        return userSheetsRepository.findUserSheetsByUserSheetsId(userSheetsId);
    }

    //display all saved sheets
    @GetMapping(path = "/allSavedSheets")
    public @ResponseBody Iterable<SavedSheets> getSavedSheets(@RequestParam Integer savedSheetsId){
        return savedSheetRepository.findSavedSheetsBySavedSheetId(savedSheetsId);
    }

    //display all information on a user's sheet
    @GetMapping(path = "/userSheetInfo")
    public @ResponseBody Iterable<Sheet> getUserSheet(@RequestParam Integer sheetId){
        return  sheetRepository.findSheetBySheetId(sheetId);
    }


}
