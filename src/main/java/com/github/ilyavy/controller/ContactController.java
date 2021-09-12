package com.github.ilyavy.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.github.ilyavy.dto.ContactDto;
import com.github.ilyavy.model.Contact;
import com.github.ilyavy.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/v1/")
@RestController
public class ContactController {

    private ContactService contactService;

    private ModelMapper modelMapper;

    @Autowired
    public ContactController(ContactService contactService, ModelMapper modelMapper) {
        this.contactService = contactService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDto create(@RequestBody ContactDto contactDto) {
        final Contact contact =  contactService.create(modelMapper.map(contactDto, Contact.class));
        return modelMapper.map(contact, ContactDto.class);
    }

    @GetMapping("/contacts")
    public List<ContactDto> getAll(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
        return contactService.getAll(limit, offset)
                .stream()
                .map(c -> modelMapper.map(c, ContactDto.class))
                .collect(Collectors.toList());
    }
}
