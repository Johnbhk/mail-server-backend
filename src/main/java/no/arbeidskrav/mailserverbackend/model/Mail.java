package no.arbeidskrav.mailserverbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mails")
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto inc. key
    private Long id;

    @Column(name = "fromMail")
    private String fromMail;
    @Column(name = "toMail")
    private String toMail;
    @Column(name = "subject")
    private String subject;
    @Column(name = "body")
    private String body;
    @Column(name = "timestamp")
    private String timestamp;

    public Mail(Long id, String fromMail, String toMail, String subject, String body, String timestamp) {
        this.id = id;
        this.fromMail = fromMail;
        this.toMail = toMail;
        this.subject = subject;
        this.body = body;
        this.timestamp = timestamp;
    }

    public Mail(String fromMail, String subject, String body, boolean b) {
    }


    @Override
    public String toString() {
        return "Mail [id=" + id + ", from Mail=" + fromMail + ", To Mail=" + toMail 
                + ", Subject=" + subject + ", Body="
                + body +", Timestamp=" + timestamp +"]";
    }



}