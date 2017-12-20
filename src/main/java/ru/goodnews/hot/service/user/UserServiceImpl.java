package ru.goodnews.hot.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goodnews.hot.model.User;
import ru.goodnews.hot.repository.UserRepository;
import ru.goodnews.hot.util.exception.NotFoundException;

import java.util.List;

// Зашита бизнес логика
@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public User findOne(Long id) throws NotFoundException {
        return repository.findOne(id);
    }

    public int countDataSets(String firstName) {
        return findByFirstName(firstName).size();
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }
}
