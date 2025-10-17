package edu.snhu.cs320;

import java.util.*;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        Objects.requireNonNull(contact, "contact");
        String id = contact.getContactId();
        if (contacts.containsKey(id)) throw new IllegalArgumentException("duplicate contactId");
        contacts.put(id, contact);
    }

    public boolean deleteContact(String contactId) {
        return contacts.remove(contactId) != null;
    }

    public void updateFirstName(String contactId, String firstName) {
        get(contactId).setFirstName(firstName);
    }
    public void updateLastName(String contactId, String lastName) {
        get(contactId).setLastName(lastName);
    }
    public void updatePhone(String contactId, String phone) {
        get(contactId).setPhone(phone);
    }
    public void updateAddress(String contactId, String address) {
        get(contactId).setAddress(address);
    }

    public Contact get(String contactId) {
        Contact c = contacts.get(contactId);
        if (c == null) throw new NoSuchElementException("contactId not found");
        return c;
    }

    int size() { return contacts.size(); }
}
