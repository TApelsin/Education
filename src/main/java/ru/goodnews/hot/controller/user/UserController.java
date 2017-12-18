package ru.goodnews.hot.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.goodnews.hot.model.User;
import ru.goodnews.hot.service.user.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller // or @RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello() {
        // Filling
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setFirstName(i % 2 == 0 ? "Tom" : "Kate");
            userService.save(user);
        }





  //      user.setFirstName("John");

     //   return user.toString(); //user.toString(); //userService.hello();
    }
}
