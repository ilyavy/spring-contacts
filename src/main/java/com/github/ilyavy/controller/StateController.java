package com.github.ilyavy.controller;

import java.util.Optional;

import com.github.ilyavy.dto.StateDto;
import com.github.ilyavy.model.Contact;
import com.github.ilyavy.model.State;
import com.github.ilyavy.service.StateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1")
public class StateController {

    private final StateService stateService;

    private final ModelMapper modelMapper;

    @Autowired
    public StateController(StateService stateService, ModelMapper modelMapper) {
        this.stateService = stateService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/contacts/{contactId}/state")
    @ResponseStatus(HttpStatus.CREATED)
    public StateDto create(@PathVariable long contactId, @RequestBody StateDto stateDto) {
        final State state = modelMapper.map(stateDto, State.class);
        state.setContact(new Contact().setId(contactId));
        return modelMapper.map(stateService.create(contactId, state), StateDto.class);
    }

    @GetMapping("/contacts/{contactId}/state/{stateId}")
    public StateDto getById(@PathVariable("contactId") long contactId, @PathVariable("stateId") long stateId) {
        final Optional<State> stateOptional = stateService.getById(contactId, stateId);

        if (stateOptional.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("State %d for contact with id = %d cannot be found", stateId, contactId));
        }

        return modelMapper.map(stateOptional.get(), StateDto.class);
    }

    @GetMapping("/contacts/{contactId}/state")
    public StateDto getByContactId(@PathVariable("contactId") long contactId) {
        final Optional<State> stateOptional = stateService.getByContactId(contactId);

        if (stateOptional.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("State for contact with id = %d cannot be found", contactId));
        }

        return modelMapper.map(stateOptional.get(), StateDto.class);
    }

    @PutMapping("/contacts/{contactId}/state/{stateId}")
    public StateDto update(@PathVariable("contactId") long contactId,
                           @PathVariable("stateId") long stateId, @RequestBody StateDto stateDto) {
        final State state = stateService.update(contactId, stateId, modelMapper.map(stateDto, State.class));
        return modelMapper.map(state, StateDto.class);
    }
}
