package codesquad.springcafe.controller;

import codesquad.springcafe.domain.User;
import codesquad.springcafe.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/create")
    public String join() {
        return "/user/form";
    }

    @PostMapping("/users/create")
    public String join(@ModelAttribute User user) {
        userService.join(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String userList(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "/user/list";
    }

    @GetMapping("/users/{userId}")
    public String userDetails(@PathVariable String userId, Model model) {
        model.addAttribute("user", userService.getUser(userId));
        return "/user/profile";
    }
}
