package ru.goodnews.hot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="users")
public class User implements Serializable {

    public User() {}

    public User(String firstName) {
        this.firstName = firstName;
    }

    private Long id;
    private String firstName;
    private Set<Article> articles = new HashSet<Article>();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty(message="{validation.firstname.NotEmpty.message}")
    @Size(min=3, max=60, message="{validation.firstname.Size.message}")
    @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}

