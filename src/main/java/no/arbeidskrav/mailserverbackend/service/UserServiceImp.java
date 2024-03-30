package no.arbeidskrav.mailserverbackend.service;



import no.arbeidskrav.mailserverbackend.model.MyDTO;
import no.arbeidskrav.mailserverbackend.model.User;
import no.arbeidskrav.mailserverbackend.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalProduct = userRepository.findById(id);
        return optionalProduct.orElse(null);
    }


    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public String getEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAllEmails(String email) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public List<MyDTO> getAllDTOs() {
        return null;
    }



}
