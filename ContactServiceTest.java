package edu.snhu.cs320;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
    private ContactService svc;

    @BeforeEach
    void setup() {
        svc = new ContactService();
    }

    @Test
    void add_uniqueId_ok() {
        svc.addContact(new Contact("1","A","B","0123456789","Addr"));
        assertEquals(1, svc.size());
    }

    @Test
    void add_duplicateId_rejected() {
        svc.addContact(new Contact("1","A","B","0123456789","Addr"));
        assertThrows(IllegalArgumentException.class,
            () -> svc.addContact(new Contact("1","C","D","0123456789","Addr")));
    }

    @Test
    void delete_existing_returnsTrue() {
        svc.addContact(new Contact("1","A","B","0123456789","Addr"));
        assertTrue(svc.deleteContact("1"));
        assertEquals(0, svc.size());
    }

    @Test
    void update_fields_work() {
        svc.addContact(new Contact("1","A","B","0123456789","Addr"));
        svc.updateFirstName("1", "Amy");
        svc.updateLastName("1", "Bee");
        svc.updatePhone("1", "1112223333");
        svc.updateAddress("1", "New Address");
        Contact c = svc.get("1");
        assertEquals("Amy", c.getFirstName());
        assertEquals("Bee", c.getLastName());
        assertEquals("1112223333", c.getPhone());
        assertEquals("New Address", c.getAddress());
    }
}
