package ru.goodnews.hot.service.user;

import ru.goodnews.hot.model.User;
import ru.goodnews.hot.util.exception.NotFoundException;

public interface UserService {
    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    String hello();

}
