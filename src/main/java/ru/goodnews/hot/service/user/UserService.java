package ru.goodnews.hot.service.user;

import ru.goodnews.hot.model.User;
import ru.goodnews.hot.repository.UserRepository;
import ru.goodnews.hot.util.exception.NotFoundException;

import java.util.List;


public interface UserService {

    public void setRepository(UserRepository repository);

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    int countDataSets(String firstName);

    List<User> findByFirstName(String firstName);

}
