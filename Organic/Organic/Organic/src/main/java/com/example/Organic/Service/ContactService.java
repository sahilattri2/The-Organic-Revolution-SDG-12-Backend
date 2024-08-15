package com.example.Organic.Service;

import com.example.Organic.entity.Contact;
import com.example.Organic.Repository.ContactRepository;
import com.example.Organic.utils.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final EmailSender emailSender;

    @Autowired
    public ContactService(ContactRepository contactRepository, EmailSender emailSender) {
        this.contactRepository = contactRepository;
        this.emailSender = emailSender;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public Contact addContact(Contact contact) {
        // Save the contact
        Contact savedContact = contactRepository.save(contact);

        // Send email notification
        sendEmailNotification(savedContact);

        return savedContact;
    }

    private void sendEmailNotification(Contact contact) {
        String recipientEmail = "jk21walasahil@gmail.com"; // Change to your recipient email
        String subject = "New Contact Form Submission";
        String messageBody = "A new contact form submission has been received.\n\n" +
                "Name: " + contact.getName() + "\n" +
                "Email: " + contact.getEmail() + "\n" +
                "Phone: " + contact.getPhone() + "\n" +
                "Message: " + contact.getMessage();

        // Send email using EmailSender
        emailSender.sendEmail(recipientEmail, subject, messageBody);
    }

    public boolean updateContact(Long id, Contact updatedContact) {
        if (contactRepository.existsById(id)) {
            updatedContact.setId(id);
            contactRepository.save(updatedContact);
            return true;
        }
        return false;
    }

    public Contact deleteContact(Long id) {
        Contact contact = contactRepository.findById(id).orElse(null);
        if (contact != null) {
            contactRepository.deleteById(id);
        }
        return contact;
    }
}
