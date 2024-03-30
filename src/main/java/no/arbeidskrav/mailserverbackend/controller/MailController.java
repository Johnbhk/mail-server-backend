package no.arbeidskrav.mailserverbackend.controller;

import no.arbeidskrav.mailserverbackend.model.Mail;
import no.arbeidskrav.mailserverbackend.model.MyDTO;
import no.arbeidskrav.mailserverbackend.repository.MailRepository;
import no.arbeidskrav.mailserverbackend.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/mails")
public class MailController {
    private final MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mail> getMailById(@PathVariable long id) {
        Optional<Mail> mailData = Optional.ofNullable(mailService.getMailById(id));

        if (mailData.isPresent()) {
            return new ResponseEntity<>(mailData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/to/{to}")
    public ResponseEntity<List<Mail>> findByToMail(@RequestParam(required = false) String toMail) {
        try {
            List<Mail> mails = mailService.getAllByToMail(String.valueOf(true));

            if (mails.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else
            return new ResponseEntity<>(mails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/from/{from}")
    public ResponseEntity<List<Mail>> getAllMails(@RequestParam(required = false) String fromMail) {
        try {
            List<Mail> mails = new ArrayList<>();

            if (fromMail == null)
                mails.addAll(mailService.getAllMails());//
            else
                mails.addAll(mailService.getAllByFromMail(fromMail));

            if (mails.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(mails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Mail> createMail(@RequestBody Mail mail) {
        try {
            Mail _mail = mailService
                    .save(new Mail(mail.getFromMail(), mail.getSubject(), mail.getBody(), false));
            return new ResponseEntity<>( _mail, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mail> updateMail(@PathVariable("id") long id, @RequestBody Mail mail) {
        Optional<Mail> mailData = mailService.getById(id);

        if (mailData.isPresent()) {
            Mail _mail = mailData.get();
            _mail.setFromMail(mail.getFromMail());
            _mail.setSubject(mail.getSubject());
            _mail.setBody(mail.getBody());
            return new ResponseEntity<>(mailService.save(_mail), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMail(@PathVariable("id") long id) {
        try {
            mailService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

}
    @GetMapping("/dto")
    public List<MyDTO> getAllDTOs() {
        return mailService.getAllDTOs();
    }

    @GetMapping("/domain/{domain}")
    public List<Mail> getAllFromDomain(@PathVariable String domain) {
        return mailService.getMailsByDomain(domain);
    }

}








