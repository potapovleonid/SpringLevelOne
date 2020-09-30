package home.des.services;

import home.des.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Long id);

    User save(User user);
}
