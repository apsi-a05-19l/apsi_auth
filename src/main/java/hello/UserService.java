package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Null;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;


@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void saveUser(@RequestParam String username,
                         @RequestParam String email,
                         @RequestParam String password) {
        User n = new User();
        n.setUsername(username);
        n.setEmail(email);
//        n.setPassword(bCryptPasswordEncoder.encode(password));
        n.setPassword(password);
        n.setToken(null); //???
        userRepository.save(n);
    }

//    public Optional<String> login(String username, String password) {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        } else {
//            if (bCryptPasswordEncoder.encode(user.getPassword()).equals(password)) {
//
//            } else {
//
//            }
//        }
//    }

}
