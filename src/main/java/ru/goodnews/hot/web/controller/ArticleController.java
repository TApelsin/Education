package ru.goodnews.hot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.goodnews.hot.model.Article;
import ru.goodnews.hot.model.User;
import ru.goodnews.hot.service.article.ArticleService;


@Controller
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @ResponseBody
    @RequestMapping(value = "/addarticles", method = RequestMethod.GET)
    public String printHello() {

        articleService.save(new Article("Sword"));
        articleService.save(new Article("Comp"));
        articleService.save(new Article("Warm"));

        return "New articles add in base";
    }
}
