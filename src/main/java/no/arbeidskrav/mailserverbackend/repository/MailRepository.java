package no.arbeidskrav.mailserverbackend.repository;

import no.arbeidskrav.mailserverbackend.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MailRepository extends JpaRepository<Mail, Long> {
    List<Mail> findAllByToMail(String toMail);
    List<Mail> findAllByFromMail(String fromMail);

    @Query(value="select * from mail where fromMail LIKE :domain", nativeQuery=true)
    List<Mail> getMailsByDomain(String domain);
}
