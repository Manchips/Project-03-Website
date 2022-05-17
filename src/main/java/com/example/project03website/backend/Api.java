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
    //tested savedSheetId 2, output = 1
    @GetMapping(path = "/findBySavedSheetId")
    public @ResponseBody SavedSheets getSavedSheetId(@RequestParam(defaultValue = "2") Integer savedSheetId){
        return savedSheetRepository.findDistinctBySavedSheetId(savedSheetId);
    }

    // find a sheet by the sheet Id
    //tested 6, output = users entire sheet sheet
    @GetMapping(path = "/findBySheetId")
    public @ResponseBody Sheet getSheetId(@RequestParam(defaultValue = "6") Integer sheetId){
        return sheetRepository.findDistinctBySheetId(sheetId);
    }

    // find a sheet by there user sheet Id
    //tested userSheetsId 1, output = 1
    @GetMapping(path = "/findByUserSheetsId")
    public @ResponseBody UserSheets getUserSheetsId(@RequestParam(defaultValue = "1") Integer userSheetsId){
        return userSheetsRepository.findDistinctByUserSheetsId(userSheetsId);
    }

    //display all sheets user has
    //tested userSheetsId = 1, output = []
    @GetMapping(path = "/allUserSheets")
    public @ResponseBody Iterable<UserSheets> getUserSheets(@RequestParam(defaultValue = "3") Integer userSheetsId){
        return userSheetsRepository.findUserSheetsByUserSheetsId(userSheetsId);
    }

    //display all saved sheets
    //tested savedSheetsId = 1, output = []
    @GetMapping(path = "/allSavedSheets")
    public @ResponseBody Iterable<SavedSheets> getSavedSheets(@RequestParam(defaultValue = "4") Integer savedSheetsId){
        return savedSheetRepository.findSavedSheetsBySavedSheetId(savedSheetsId);
    }

    //display all information on a user's sheet
    //currently test/works with sheetId = 6
    @GetMapping(path = "/userSheetInfo")
    public @ResponseBody Iterable<Sheet> getUserSheet(@RequestParam(defaultValue = "6") Integer sheetId){
        //return  sheetRepository.findAll();
        return  sheetRepository.findSheetBySheetId(sheetId);
    }

    //create a new character sheet
    //currently error 500
    @PostMapping(path="/makeNewSheet")
    public @ResponseBody String makeNewSheet(@RequestParam(defaultValue = "10") String characterNameURL, @RequestParam String className,
                                             @RequestParam Integer body_Stat, @RequestParam Integer mind_Stat){
        Sheet sheet = new Sheet();
        sheet.setCharacterNameURL(characterNameURL);
        sheet.setClassName(className);
        sheet.setBody_Stat(body_Stat);
        sheet.setMind_Stat(mind_Stat);
        sheetRepository.save(sheet);

        return "saved";
    }


}
