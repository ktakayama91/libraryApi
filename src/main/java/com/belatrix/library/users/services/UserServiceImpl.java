package com.belatrix.library.users.services;

import com.belatrix.library.users.model.User;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kei Takayama
 * Created on 6/13/17.
 */
public class UserServiceImpl implements UserService {

    private static List<User> users = new ArrayList<>(Arrays
            .asList(
                    new User(1,"Juan", "Perez","12345678",25, "M")
            ));
    private static Integer ID = 1;
    private static Integer ACTIVE_USER = 1;

    @Override
    public List<User> getUsers() {
        return users.stream()
                .filter(user -> user.getStatus().equals(ACTIVE_USER))
                .collect(Collectors.toList());
    }

    @Override
    public Integer createUser(User user){
        users.add(new User(++ID, user.getName(), user.getLastname(), user.getDocumentNumber(), user.getAge(), user.getGender()));
        return ID;
    }

    @Override
    public User findUserById(Integer id) {
        User existentUser = users.stream()
                .filter(user -> user.getId().equals(id))
                .filter(user -> user.getStatus().equals(ACTIVE_USER))
                .findFirst()
                .orElse(null);

        if(existentUser == null) {
            throw new NotFoundException("User does not exist");
        }

        return existentUser;
    }

    @Override
    public void deleteUser(Integer id){

        User existentUser = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst().orElse(null);

        if (existentUser == null) {
            throw new NotFoundException("User does not exist");
        }

        users.remove(existentUser);
    }

}
