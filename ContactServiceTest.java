package Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    public void testCannotAddDuplicateContactId() {

        Contact contact1 = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street"
        );

        Contact contact2 = new Contact(
                "12345",
                "Jane",
                "Doe",
                "0987654321",
                "456 Main Street"
        );

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    public void testDeleteContact() {

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.deleteContact("12345");

        assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("12345");
        });
    }

    @Test
    public void testUpdateFirstName() {

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.updateFirstName("12345", "Jane");

        assertEquals("Jane", service.getContact("12345").getFirstName());
    }

    @Test
    public void testUpdateLastName() {

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.updateLastName("12345", "Doe");

        assertEquals("Doe", service.getContact("12345").getLastName());
    }

    @Test
    public void testUpdatePhone() {

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.updatePhone("12345", "0987654321");

        assertEquals("0987654321", service.getContact("12345").getPhone());
    }

    @Test
    public void testUpdateAddress() {

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.updateAddress("12345", "456 New Street");

        assertEquals("456 New Street", service.getContact("12345").getAddress());
    }
}
