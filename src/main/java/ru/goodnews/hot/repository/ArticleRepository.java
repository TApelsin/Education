package ru.goodnews.hot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.goodnews.hot.model.Article;
import ru.goodnews.hot.model.User;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

}
