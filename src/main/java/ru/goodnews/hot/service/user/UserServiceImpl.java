package ru.goodnews.hot.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goodnews.hot.model.User;
import ru.goodnews.hot.repository.UserRepository;
import ru.goodnews.hot.util.exception.NotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        //return repository.save(user);
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public User get(int id) throws NotFoundException {
        return null;
    }

    public String hello() {
        return "Hello, World!";
    }
}
