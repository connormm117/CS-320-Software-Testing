package edu.snhu.cs320;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {
    @Test
    void ctor_valid() {
        Contact c = new Contact("A1","John","Doe","0123456789","123 Main St");
        assertEquals("A1", c.getContactId());
        assertEquals("John", c.getFirstName());
    }

    @Test
    void ctor_rejectsBadPhone() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("A1","John","Doe","123456789", "addr")); // 9 digits
    }

    @Test
    void setters_enforceRules() {
        Contact c = new Contact("ID","A","B","0123456789","Addr");
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("abcdefghij"));
        c.setAddress("123456789012345678901234567890"); // exactly 30 chars ok
        assertEquals(30, c.getAddress().length());
        assertThrows(IllegalArgumentException.class, () -> c.setAddress("x".repeat(31)));
    }
}
