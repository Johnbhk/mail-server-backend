package no.arbeidskrav.mailserverbackend.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyDTO {
    @Id
    private Long id;
    private String username;
    private String email;
    public MyDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

