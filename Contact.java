package edu.snhu.cs320;

import java.util.Objects;

public final class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;   // exactly 10 digits
    private String address; // <= 30 chars

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        this.contactId = validateId(contactId);
        this.firstName = validateRequiredLen(firstName, 10, "firstName");
        this.lastName  = validateRequiredLen(lastName, 10, "lastName");
        this.phone     = validatePhone(phone);
        this.address   = validateRequiredLen(address, 30, "address");
    }

    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getPhone()     { return phone; }
    public String getAddress()   { return address; }

    public void setFirstName(String firstName) {
        this.firstName = validateRequiredLen(firstName, 10, "firstName");
    }
    public void setLastName(String lastName) {
        this.lastName = validateRequiredLen(lastName, 10, "lastName");
    }
    public void setPhone(String phone) {
        this.phone = validatePhone(phone);
    }
    public void setAddress(String address) {
        this.address = validateRequiredLen(address, 30, "address");
    }

    private static String validateId(String id) {
        if (id == null || id.length() > 10) throw new IllegalArgumentException("contactId invalid");
        return id;
    }
    private static String validateRequiredLen(String v, int max, String field) {
        if (v == null || v.length() > max) throw new IllegalArgumentException(field + " invalid");
        return v;
    }
    private static String validatePhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("phone must be exactly 10 digits");
        }
        return phone;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact c = (Contact) o;
        return contactId.equals(c.contactId);
    }
    @Override public int hashCode() { return Objects.hash(contactId); }
}
