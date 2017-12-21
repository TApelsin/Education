package ru.goodnews.hot.service.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goodnews.hot.model.Article;
import ru.goodnews.hot.model.User;
import ru.goodnews.hot.repository.ArticleRepository;
import ru.goodnews.hot.util.exception.NotFoundException;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository repository;

    @Autowired
    public void setRepository(ArticleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Article save(Article article) {
        return repository.save(article);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public Article findOne(Long id) throws NotFoundException {
        return repository.findOne(id);
    }

    public List<Article> findByUser_firstNameLikeIgnoreCase(String firstName) {
        return repository.findByUser_firstNameLikeIgnoreCase(firstName);
    }
}
