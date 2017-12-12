package ru.goodnews.hot.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.goodnews.hot.model.User;
import ru.goodnews.hot.service.user.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    public User save(User user) {
       return service.save(user);
    }

    void delete(int id) {
        service.delete(id);
    }

    public User get(int id) {
        return service.get(id);
    }

}
