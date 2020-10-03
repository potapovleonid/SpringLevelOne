package home.des.services;

import home.des.domain.Role;
import home.des.domain.User;
import home.des.repository.UserDAO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
        initializDB();
    }

    private void initializDB() {
        userDAO.saveAll(Arrays.asList(
                new User(null, "Ivan", "ivan", Role.MANAGER),
                new User(null, "Petr", "petr", Role.MANAGER),
                new User(null, "Alex", "alex", Role.MANAGER),
                new User(null, "Dmitriy", "dmitriy", Role.MANAGER),
                new User(null, "Sergey", "sergey", Role.ADMIN),
                new User(null, "Leonid", "leonid", Role.SUPER_ADMIN)
        ));
    }

    @Override
    public List<User> getAll() {
        return userDAO.findAll();
    }



    @Override
    public User getById(Long id) {
        return userDAO.findById(id).orElse(null);
    }

    @Override
    public User auth(String name, String password) {
        if(name == null || name.isEmpty()){
            System.out.println("You are not authenticated");
            return null;
        }
        User user = userDAO.findFirstByName(name);
        if(user == null){
            System.out.println("You are not authenticated");
            return null;
        }
        if(!Objects.equals(password, user.getPassword())){
            System.out.println("You are not authenticated");
            return null;
        }
        System.out.println("You are authenticated");
        return user;
    }

    @Override
    public void delete(Long id) {
        userDAO.deleteUserById(id);
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDAO.findFirstByName(s);
    }
}
