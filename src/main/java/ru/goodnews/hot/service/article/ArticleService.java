package ru.goodnews.hot.service.article;

import ru.goodnews.hot.model.Article;
import ru.goodnews.hot.model.User;
import ru.goodnews.hot.repository.ArticleRepository;
import ru.goodnews.hot.util.exception.NotFoundException;

import java.util.List;

public interface ArticleService {
    public void setRepository(ArticleRepository repository);

    Article save(Article article);

    void delete(Long id) throws NotFoundException;

    Article findOne(Long id) throws NotFoundException;

    List<Article> findByUser_firstNameLikeIgnoreCase(String firstName);
}
