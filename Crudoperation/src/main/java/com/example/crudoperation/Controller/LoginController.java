package com.example.crudoperation.Controller;

import com.example.crudoperation.dto.UserDto;
import com.example.crudoperation.entity.User;
import com.example.crudoperation.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/sigin")
    public String loginForm(HttpServletRequest request, Authentication authentication) {
        HttpSession session = request.getSession();

        Object attribute = session.getAttribute("userLoggedIn");
        System.out.println(attribute + "  is not null");
        if (attribute!=null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            if (authorities != null && !authorities.isEmpty()) {
                for (GrantedAuthority grantedAuthority : authorities) {
                    if (grantedAuthority.getAuthority().equals("USER")) {
                        return "redirect:/dashboard";
                    }
                }
            }
        }


        return "/sigin";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }


    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        User existing = userService.findByEmail(user.getEmail());
        User name=userService.findByUsername(user.getUsername());
        if (existing != null||name !=null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
            result.rejectValue("username", null, "There is already an account registered with that username");
        }
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }
}
