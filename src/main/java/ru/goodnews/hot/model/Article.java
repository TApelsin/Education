package ru.goodnews.hot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="articles")
public class Article {

    public Article() {}

    public Article(String titleArticle, ) {
        this.titleArticle = titleArticle;
    }

    private Long id;
    private String titleArticle;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty(message="{validation.titleArticle.NotEmpty.message}")
    @Size(min=3, max=60, message="{validation.titleArticle.Size.message}")
    @Column(name = "titleArticle")
    public String getTitleArticle() {
        return titleArticle;
    }

    public void setTitleArticle(String titleArticle) {
        this.titleArticle = titleArticle;
    }

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", titleArticle='" + titleArticle + '\'' +
                ", user=" + user +
                '}';
    }
}
