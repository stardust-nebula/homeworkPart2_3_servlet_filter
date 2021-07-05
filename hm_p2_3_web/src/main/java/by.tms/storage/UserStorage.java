package by.tms.storage;

import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private static List<User> userList = new ArrayList<>();

    public void save(User user) {
        userList.add(user);
    }

    public void delete(String username) {
        int indexOfUser = userList.indexOf(getByUsername(username));
        userList.remove(indexOfUser);
    }

    public User getByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean existByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


    public boolean isUserPasswordMatch(String username, String password) {
        User userMatch = getByUsername(username);
        if (userMatch.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
