package com.github.ilyavy.service;

import java.util.List;
import java.util.Optional;

import com.github.ilyavy.model.Contact;
import com.github.ilyavy.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> getAll(int limit, int offset) {
        return contactRepository.findAll(PageRequest.of(offset/limit, limit)).getContent();
    }

    public Optional<Contact> getById(long contactId) {
        return contactRepository.findById(contactId);
    }

    public Contact update(long contactId, Contact contact) {
        contact.setId(contactId);
        return contactRepository.save(contact);
    }

    public void delete(long contactId) {
        contactRepository.deleteById(contactId);
    }
}
