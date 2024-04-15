package codesquad.springcafe;

import codesquad.springcafe.database.UserDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/users")
    public String createUser(@ModelAttribute User user) {
        UserDatabase.addUser(user);
        logger.debug("add user : {}", user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> userList = UserDatabase.getUserList();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @GetMapping("/users/{userid}")
    public String showUser(@PathVariable String userid, Model model) {
        User user = UserDatabase.getUser(userid);
        model.addAttribute("user", user);
        return "user/profile";
    }

    @GetMapping("/users/{userid}/form")
    public String showUserEditForm(@PathVariable String userid, Model model) {
        model.addAttribute("userid",  userid);
        return "user/updateForm";
    }

    @PutMapping("/users/{userid}")
    public String updateUser(@ModelAttribute User editedUser) {
        User oldUser = UserDatabase.getUser(editedUser.getUserId());
        oldUser.updateUser(editedUser.getPassword(), editedUser.getName(), editedUser.getEmail());
        logger.info("update user : {}", oldUser.getUserId());
        return "redirect:/users";
    }

}
