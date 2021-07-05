package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.UserStorage;

public class UserService {

    private UserStorage userStorage = new UserStorage();

    public boolean add(User user) {
        if (userStorage.existByUsername(user.getUsername())) {
            return false;
        } else {
            userStorage.save(user);
            return true;
        }
    }

    public User findByUsername(String username) {
        if (userStorage.existByUsername(username)) {
            return userStorage.getByUsername(username);
        }
        return null;
    }

    public void changePassword(String username, String newPassword) {
        userStorage.getByUsername(username).setPassword(newPassword);
    }

    public boolean deleteAccount(String username, String password) {
        if (userStorage.isUserPasswordMatch(username, password)) {
            userStorage.delete(username);
            return true;
        }else {
            return false;
        }
    }

    public void changeUsername(String username, String newUsername) {
        userStorage.getByUsername(username).setUsername(newUsername);
    }

}
