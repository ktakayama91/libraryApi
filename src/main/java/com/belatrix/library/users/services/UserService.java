package com.belatrix.library.users.services;

import com.belatrix.library.users.model.User;

import java.util.List;

/**
 * @author Kei Takayama
 * Created on 6/13/17.
 */
public interface UserService {

    List<User> getUsers();

    Integer createUser(User user);

    User findUserById(Integer id);

    void deleteUser(Integer id);
}
