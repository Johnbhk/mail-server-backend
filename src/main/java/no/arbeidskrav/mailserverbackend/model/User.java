package no.arbeidskrav.mailserverbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users") // table name
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto incriment primary key
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;



    public User(Long id, String email, String password, String username) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public User(String username, String email, String password) {
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email
                + ", password=" + password + "]";
    }
}
