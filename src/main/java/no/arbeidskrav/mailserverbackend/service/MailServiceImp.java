package no.arbeidskrav.mailserverbackend.service;

import no.arbeidskrav.mailserverbackend.model.Mail;
import no.arbeidskrav.mailserverbackend.model.MyDTO;
import no.arbeidskrav.mailserverbackend.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class MailServiceImp implements MailService {
    private final MailRepository mailRepository;

    @Autowired
    public MailServiceImp(MailRepository mailRepository) {
        this.mailRepository = mailRepository;

    }

    @Override
    public Mail getMailById(Long id) {
        return null;
    }

    @Override
    public void saveMail(Mail mail) {

    }

    @Override
    public void deleteMail(Long id) {

    }

    @Override
    public List<Mail> getAllMails() {
        return null;
    }

    @Override
    public List<Mail> getAllFromMail(String from) {
        return null;
    }

    @Override
    public List<Mail> getAllToMail(String to) {
        return null;
    }

    @Override
    public List<Mail> getMailsByDomain(String domain) {
        return null;
    }

    @Override
    public Mail getEmailById(Long id) {
        Optional<Mail> optionalProduct = mailRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Collection<? extends Mail> getAllAllMails() {
        return null;
    }

    @Override
    public Collection<? extends Mail> getAllByFromMail(String fromMail) {
        return null;
    }

    @Override
    public List<Mail> getAllByToMail(String s) {
        return null;
    }

    @Override
    public Mail save(Mail mail) {
        return null;
    }

    @Override
    public Optional<Mail> getById(long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(long id) {

    }


    @Override
    public List<MyDTO> getAllDTOs() {
        ArrayList<MyDTO> myDTOS = new ArrayList<>();
        myDTOS.add(new MyDTO("u1", "e1"));
        myDTOS.add(new MyDTO("u2", "e2"));
        return myDTOS;
    }
}
