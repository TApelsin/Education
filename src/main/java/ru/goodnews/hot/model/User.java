package ru.goodnews.hot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="user")
public class User implements Serializable {
 //   private static final long serialVersionUID = -8706689714326132798L;

//    public User() {}
//
//    public User(String firstName) {
//        this.firstName = firstName;
//    }

    private Long id;
    private String firstName;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //@NotEmpty(message="{validation.firstname.NotEmpty.message}")
    //@Size(min=3, max=60, message="{validation.firstname.Size.message}")
    @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

