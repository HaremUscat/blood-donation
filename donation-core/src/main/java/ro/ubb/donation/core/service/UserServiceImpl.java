package ro.ubb.donation.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.donation.core.model.Role;
import ro.ubb.donation.core.model.User;
import ro.ubb.donation.core.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findUser(int userId) {
        log.trace("findUser:userId={}", userId);
        Optional<User> userOptional= userRepository.findById(userId);
        log.trace("findUser: userOptional={}", userOptional);
        return userOptional;
    }

    @Override
    public List<User> findAll() {
        log.trace("findAll --- method entered");

        List<User> users = userRepository.findAll();

        log.trace("findAll: users={}", users);

        return users;
    }

    @Override
    @Transactional
    public User updateUser(int userId, String username, String password, boolean logged, Role role) {
        log.trace("updateUser: username={}, password={}, logged={}, role={}", username, password, logged, role);

        Optional<User> user = userRepository.findById(userId);

        user.ifPresent(u -> {
            u.setUsername(username);
            u.setPassword(password);
            u.setLogged(logged);
            u.setRole(role);
        });

        log.trace("updateUser: user={}", user.get());

        return user.orElse(null);
    }

    @Override
    public User createUser(String username, String password, boolean logged, Role role) {
        log.trace("createUser: username={}, password={}, logged={}, role={}",
                username, password, logged, role);

        User user = User.builder()
                .username(username)
                .password(password)
                .logged(logged)
                .role(role)
                .build();
        user = userRepository.save(user);

        log.trace("createUser: user={}", user);

        return user;
    }

    @Override
    @Transactional
    public void deleteUser(int userId) {
        log.trace("deleteUser: userId={}", userId);

        userRepository.deleteById(userId);

        log.trace("deleteUser - method end");
    }
}
