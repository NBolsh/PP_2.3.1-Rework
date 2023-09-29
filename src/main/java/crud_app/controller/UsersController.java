package crud_app.controller;

import crud_app.model.User;
import crud_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UsersController {
    private UserService userService;


    @Autowired
    public UsersController(UserService userService){
        this.userService = userService;
    }

    @GetMapping( "/users")
    public String showAllUsers(Model model){

        model.addAttribute("allUsers", userService.getAllUsers());

        return "/users/list";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        model.addAttribute("user",new User());
        return "/users/userInfo";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") @Valid User user,
                          BindingResult bindingResult){


        if (bindingResult.hasErrors()) { return "/users/userInfo"; }

        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit")
    public String findUser(@RequestParam("userId") long id,
                           Model model){
        model.addAttribute("user", userService.findUserById(id));
        return "/users/userInfo";
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam("userId") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
