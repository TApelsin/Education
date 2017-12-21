package ru.goodnews.hot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.goodnews.hot.model.Article;
import ru.goodnews.hot.model.User;
import ru.goodnews.hot.service.user.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller // or @RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // Примитивное заполнение данными
    // По запросу /hello возвращает строку
    @ResponseBody
    @RequestMapping(value = "/addusers", method = RequestMethod.GET)
    public String printHello() {
        // Filling
        User userJohn = new User("John");
        User userKate = new User("Kate");

        final Article articleMouse = new Article("Mouse", userKate);
        final Article articleComp = new Article("Comp", userKate);
        final Article articleTea = new Article("Tea", userJohn);
        final Article articleApple = new Article("Apple", userJohn);
        final Article articleEat = new Article("Eat", userJohn);
        userJohn.setArticles(new HashSet<Article>(){{
            add(articleApple);
            add(articleEat);
            add(articleTea);
        }});
        userKate.setArticles(new HashSet<Article>(){{
            add(articleComp);
            add(articleMouse);
        }});

        userService.save(userJohn);
        userService.save(userKate);

        return "New users add in base";
    }

    // Проверка, что в базе что-то есть
    // По запросу /getqty возвращает кол-во строк с задданым полем
    @ResponseBody
    @RequestMapping(value = "/getqty", method = RequestMethod.GET)
    public int getUsersByName() {
        return userService.countDataSets("Tom");
    }
}
