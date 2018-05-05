package ro.ubb.donation.core.service;

import ro.ubb.donation.core.model.Role;
import ro.ubb.donation.core.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUser(int userId);

    List<User> findAll();

    User updateUser(int userId, String username, String password, boolean logged, Role role);

    User createUser(String username, String password, boolean logged, Role role);

    void deleteUser(int userId);
}
