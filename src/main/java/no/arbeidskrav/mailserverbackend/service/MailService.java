package no.arbeidskrav.mailserverbackend.service;

import no.arbeidskrav.mailserverbackend.model.Mail;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MailService {

    Mail getMailById(Long id);

    void saveMail (Mail mail);

    void deleteMail (Long id);
    List<Mail> getAllMails ();

    List<Mail> getAllFromMail (String from);

    List<Mail> getAllToMail (String to);

    List<Mail> getMailsByDomain (String domain);

    Mail getEmailById(Long id);

    <MyDTO> List<MyDTO> getAllDTOs();


    Collection<? extends Mail> getAllAllMails();

    Collection<? extends Mail> getAllByFromMail(String fromMail);

    List<Mail> getAllByToMail(String s);

    Mail save(Mail mail);

    Optional<Mail> getById(long id);

    void deleteById(long id);
}
