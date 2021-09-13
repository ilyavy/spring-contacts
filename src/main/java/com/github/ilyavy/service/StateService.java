package com.github.ilyavy.service;

import java.util.Optional;

import com.github.ilyavy.model.State;
import com.github.ilyavy.repository.ContactRepository;
import com.github.ilyavy.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    private final ContactRepository contactRepository;

    private final StateRepository stateRepository;

    @Autowired
    public StateService(ContactRepository contactRepository, StateRepository stateRepository) {
        this.contactRepository = contactRepository;
        this.stateRepository = stateRepository;
    }

    public State create(long contactId, State state) {
        if (!contactRepository.existsById((contactId))) {
            throw new IllegalArgumentException(String.format("Contact with id %d does not exist", contactId));
        }
        if (getByContactId(contactId).isPresent()) {
            throw new IllegalArgumentException(String.format("State for contact with id %d already exists", contactId));
        }
        return stateRepository.save(state);
    }

    public Optional<State> getById(long contactId, long stateId) {
        if (!contactRepository.existsById((contactId))) {
            throw new IllegalArgumentException(String.format("Contact with id %d does not exist", contactId));
        }
        return stateRepository.findById(stateId);
    }

    public Optional<State> getByContactId(long contactId) {
        if (!contactRepository.existsById((contactId))) {
            throw new IllegalArgumentException(String.format("Contact with id %d does not exist", contactId));
        }
        return stateRepository.findFirstByContactId(contactId);
    }

    public State update(long contactId, long stateId, State state) {
        if (!contactRepository.existsById((contactId))) {
            throw new IllegalArgumentException(String.format("Contact with id %d does not exist", contactId));
        }

        state.setId(stateId);
        return stateRepository.save(state);
    }
}
