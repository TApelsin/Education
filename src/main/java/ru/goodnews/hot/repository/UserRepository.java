package ru.goodnews.hot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.goodnews.hot.model.User;

import java.util.List;

// Spring сам создает bean c crud методами
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // Метод, функциональность которого зависит от названия
    // findBy - шаблон, ищет только те строки, где встречается указанное имя
    List<User> findByFirstName(String firstName);
}


