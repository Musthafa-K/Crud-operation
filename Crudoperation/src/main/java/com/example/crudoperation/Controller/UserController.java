package com.example.crudoperation.Controller;



import com.example.crudoperation.dto.UserDto;
import com.example.crudoperation.entity.User;
import com.example.crudoperation.security.CustomerUserDetails;
import com.example.crudoperation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String listRegisteredUsers( Model model, Principal principal){
        String name= principal.getName();
        System.out.println(name +" from principal");
        List<UserDto> users = userService.findAllByRole("USER");
        model.addAttribute("users", users);
        model.addAttribute("name", name);
        return "dashboard";
    }

    @GetMapping("/dashboard/update/{id}")
    public String showUpdateUser(@PathVariable int id, Model model){
        UserDto existing=userService.findById(id);
        model.addAttribute("user",existing);
        return "updateuser";
    }

    @PostMapping("/dashboard/update/{id}")
    public String updateUser(@ModelAttribute("user") UserDto user, @PathVariable("id") int id, BindingResult result, Model model) {
        User emailUser = userService.findByEmail(user.getEmail());
        User usernameUser = userService.findByUsername(user.getUsername());

        if (emailUser != null && !emailUser.getId().equals(id)) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (usernameUser != null && !usernameUser.getId().equals(id)) {
            result.rejectValue("username", null, "There is already an account registered with that username");
        }

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            model.addAttribute("user", user);
            return "updateuser";
        }
        userService.updateUser(user);
        return "redirect:/dashboard";
    }
    @GetMapping("/dashboard/delete/{id}")
    public String deleteUser(@PathVariable int id,Model model){
        System.out.println("Number is "+ id);
        System.out.println("delete controller");
        userService.deleteUserById(id);
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard/adduser")
    public String showAddUser(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "adduser";
    }

    @PostMapping("/dashboard/adduser/save")
    public String addUser(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        System.out.println("add user controller");
        User existing = userService.findByEmail(user.getEmail());
        User name=userService.findByUsername(user.getUsername());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (name !=null){
            result.rejectValue("name", null, "There is already an account registered with that name");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "adduser";
        }
        userService.saveUser(user);
        return "redirect:/dashboard/adduser?success";
    }

    @GetMapping("/dashboard/search")
    public String search(@RequestParam("name")String name,Model model){
        List<UserDto> users = userService.searchUser("USER",name);
        model.addAttribute("users",users);

        return "dashboard";
    }

    






}
