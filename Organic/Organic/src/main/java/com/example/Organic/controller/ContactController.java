package com.example.Organic.controller;

import com.example.Organic.entity.Contact;
import com.example.Organic.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @PutMapping("/{id}")
    public boolean updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        return contactService.updateContact(id, updatedContact);
    }

    @DeleteMapping("/{id}")
    public Contact deleteContact(@PathVariable Long id) {
        return contactService.deleteContact(id);
    }
}
