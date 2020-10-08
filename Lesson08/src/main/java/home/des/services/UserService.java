package home.des.services;

import home.des.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<User> getAll();

    User getById(Long id);
    User auth(String name, String password);

    void delete(Long id);
    User save(User user);
}
