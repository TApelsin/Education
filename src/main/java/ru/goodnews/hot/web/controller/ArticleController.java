package ru.goodnews.hot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.goodnews.hot.model.Article;
import ru.goodnews.hot.model.User;
import ru.goodnews.hot.service.article.ArticleService;

import java.util.List;


@Controller
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "/getarticles", method = RequestMethod.GET)
    public ModelAndView getArticlesView() {
        ModelAndView mv = new ModelAndView("articlesView");
        mv.addObject("articlesModel", articleService.findByUser_firstNameLikeIgnoreCase("John"));
        return mv;
    }
}
