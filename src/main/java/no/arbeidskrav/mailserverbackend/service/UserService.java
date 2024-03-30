package no.arbeidskrav.mailserverbackend.service;

import no.arbeidskrav.mailserverbackend.model.MyDTO;
import no.arbeidskrav.mailserverbackend.model.User;

import java.util.List;

public interface UserService {
    static String getUserByUsername(String username) {
        return username;
    }
    User getUserById(Long id);

    List<User> getAllUsers();

    String getEmail(String email);
    List<User> getAllEmails(String email);

    void saveUser(User user);

    void deleteUser(Long id);

    List<MyDTO> getAllDTOs();



}
