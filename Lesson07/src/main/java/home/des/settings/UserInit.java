package home.des.settings;

import home.des.domain.User;
import home.des.repository.UserDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Component
public class UserInit implements CommandLineRunner {
    private final UserDAO userDAO;

    public UserInit(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeDB();
    }

    private void initializeDB(){
        userDAO.saveAll(Arrays.asList(
                new User(null, "Ivan", "Ivanov"),
                new User(null, "Petr", "Petrov"),
                new User(null, "Alex", "Alexandrov"),
                new User(null, "Dmitriy", "Dmitriev"),
                new User(null, "Sergey", "Sergeev"),
                new User(null, "Leonid", "Leonidov")
        ));
    }
}
