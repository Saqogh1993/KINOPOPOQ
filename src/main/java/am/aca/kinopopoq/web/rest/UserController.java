package am.aca.kinopopoq.web.rest;

import am.aca.kinopopoq.repository.entity.User;
import am.aca.kinopopoq.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/main")
    public String goMain() {
        return "main";
    }

    @GetMapping("/login")
    public String loginPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/main";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model ) {
        if(user.getPassword() != null && !user.getPassword().equals(user.getPassword2())){
            model.addAttribute("passwordError2", "Passwords are different");
            return "registration";
        }
        if(bindingResult.hasErrors()){
            Map<String,String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registration";
        }
        if (!userService.addUser(user)) {
            model.addAttribute("usernameError","User Exists!");
            model.addAttribute("passwordError","");
            model.addAttribute("emailError","");
            return "registration";
        }

        return "redirect:/login";
    }
    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivated = userService.activateUser(code);
        if(isActivated){
            model.addAttribute("message", "User successfully activated");
        }else {
            model.addAttribute("message","Activation code is not found");
        }
        return "login";
    }
}
