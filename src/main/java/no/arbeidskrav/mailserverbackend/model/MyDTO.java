package no.arbeidskrav.mailserverbackend.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyDTO {
    @Id
    private Long id; // primary key
    private String username;
    private String email;

    // constructor
    public MyDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

