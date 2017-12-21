package ru.goodnews.hot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.goodnews.hot.model.Article;


import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findByUser_firstNameLikeIgnoreCase(String firstName);
}
