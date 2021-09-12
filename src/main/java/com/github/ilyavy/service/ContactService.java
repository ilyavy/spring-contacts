package com.github.ilyavy.service;

import java.util.List;

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
}
