package Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

    // Helper method to create a valid contact for setter tests
    private Contact createValidContact() {
        return new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street"
        );
    }

    // =========================
    // Contact Constructor Tests
    // =========================

    @Test
    public void testContactCreation() {
        Contact contact = createValidContact();

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "John", "Smith",
                        "1234567890", "123 Main Street"));
    }

    @Test
    public void testContactIdCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "John", "Smith",
                        "1234567890", "123 Main Street"));
    }

    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", null, "Smith",
                        "1234567890", "123 Main Street"));
    }

    @Test
    public void testFirstNameCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Christopher", "Smith",
                        "1234567890", "123 Main Street"));
    }

    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", null,
                        "1234567890", "123 Main Street"));
    }

    @Test
    public void testLastNameCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Christopher",
                        "1234567890", "123 Main Street"));
    }

    @Test
    public void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Smith",
                        null, "123 Main Street"));
    }

    @Test
    public void testPhoneMustContainTenDigits() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Smith",
                        "123456789", "123 Main Street"));
    }

    @Test
    public void testPhoneCannotContainLetters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Smith",
                        "12345ABCDE", "123 Main Street"));
    }

    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Smith",
                        "1234567890", null));
    }

    @Test
    public void testAddressCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Smith",
                        "1234567890",
                        "This address is definitely longer than thirty characters"));
    }

    // =========================
    // First Name Setter Tests
    // =========================

    @Test
    public void testSetFirstNameValid() {
        Contact contact = createValidContact();

        contact.setFirstName("Michael");

        assertEquals("Michael", contact.getFirstName());
    }

    @Test
    public void testSetFirstNameNull() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setFirstName(null));
    }

    @Test
    public void testSetFirstNameTooLong() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setFirstName("Christopher"));
    }

    @Test
    public void testSetFirstNameMaximumLength() {
        Contact contact = createValidContact();

        contact.setFirstName("ChrisSmith");

        assertEquals("ChrisSmith", contact.getFirstName());
    }

    // =========================
    // Last Name Setter Tests
    // =========================

    @Test
    public void testSetLastNameValid() {
        Contact contact = createValidContact();

        contact.setLastName("Johnson");

        assertEquals("Johnson", contact.getLastName());
    }

    @Test
    public void testSetLastNameNull() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setLastName(null));
    }

    @Test
    public void testSetLastNameTooLong() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setLastName("Christopher"));
    }

    @Test
    public void testSetLastNameMaximumLength() {
        Contact contact = createValidContact();

        contact.setLastName("Johnson123");

        assertEquals("Johnson123", contact.getLastName());
    }

    // =========================
    // Phone Setter Tests
    // =========================

    @Test
    public void testSetPhoneValid() {
        Contact contact = createValidContact();

        contact.setPhone("0987654321");

        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testSetPhoneNull() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setPhone(null));
    }

    @Test
    public void testSetPhoneTooShort() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setPhone("123456789"));
    }

    @Test
    public void testSetPhoneTooLong() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setPhone("12345678901"));
    }

    @Test
    public void testSetPhoneWithLetters() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setPhone("12345ABCDE"));
    }

    @Test
    public void testSetPhoneWithSymbols() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setPhone("123-456-78"));
    }

    // =========================
    // Address Setter Tests
    // =========================

    @Test
    public void testSetAddressValid() {
        Contact contact = createValidContact();

        contact.setAddress("456 Oak Street");

        assertEquals("456 Oak Street", contact.getAddress());
    }

    @Test
    public void testSetAddressNull() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setAddress(null));
    }

    @Test
    public void testSetAddressTooLong() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setAddress(
                        "This address is definitely longer than thirty characters"));
    }

    @Test
    public void testSetAddressMaximumLength() {
        Contact contact = createValidContact();

        String address = "123456789012345678901234567890";

        contact.setAddress(address);

        assertEquals(address, contact.getAddress());
    }
}