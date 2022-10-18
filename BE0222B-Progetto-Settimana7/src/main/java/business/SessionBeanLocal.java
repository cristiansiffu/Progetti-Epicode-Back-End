package business;

import java.util.List;

import data.Contact;
import jakarta.ejb.Local;

@Local
public interface SessionBeanLocal {
	public List<Contact> getAllContacts();

	public void addContact(Contact contatto);

	public Contact getById(Long id);

	public List<Contact> getContactByLastname(String lastName);

	public List<Contact> getContactByNumber(String number);

	public void updateContact(Contact contact);

	public void deleteContact(Long id);
}
