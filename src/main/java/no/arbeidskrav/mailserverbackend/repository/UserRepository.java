package no.arbeidskrav.mailserverbackend.repository;

import no.arbeidskrav.mailserverbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUsername(String username);
    @Query(value="select * from user where username LIKE :domain", nativeQuery=true)
    List<User> getUserByDomain(String domain);


}
