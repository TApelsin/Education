package ru.goodnews.hot.service.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.TestException;
import ru.goodnews.hot.config.DatabaseConfig;
import ru.goodnews.hot.model.User;
import ru.goodnews.hot.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = DatabaseConfig.class)
public class UserServiceTest {



//    @InjectMocks
//    UserServiceImpl userService;

//    @Mock
//    UserRepository mockUserRepository;


    @Before
    public void setUp() {
    //    MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() throws Exception {
        UserService service = new UserServiceImpl();
        UserRepository repositoryMock = Mockito.mock(UserRepository.class);
        service.setRepository(repositoryMock);

        List<User> listUsers = new ArrayList<>();
        listUsers.add(new User());
        listUsers.add(new User());
        when(repositoryMock.findByFirstName("Marina")).thenReturn(listUsers);

        //if (service.findByFirstName("Marina").size() != 2) throw new TestException("Wrong quantity users");
        assertEquals(service.findByFirstName("Marina").size(),2);

    }
}