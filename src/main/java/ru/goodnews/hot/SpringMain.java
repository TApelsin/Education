package ru.goodnews.hot;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.goodnews.hot.web.user.UserController;

import java.util.Arrays;



public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            UserController adminUserController = appCtx.getBean(UserController.class);
//            adminUserController.create(new User(null, "userName", "email", "password", Role.ROLE_ADMIN));
        }

    }
}
