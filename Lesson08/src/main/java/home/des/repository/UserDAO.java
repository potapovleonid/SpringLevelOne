package home.des.repository;

import home.des.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findFirstByName(String name);
    User deleteUserById(Long id);
}
