package business;

import java.util.List;

import data.Contact;
import data.PhoneNumber;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
@LocalBean
public class SessionBean implements SessionBeanLocal {

	@PersistenceContext(unitName = "phoneBookPersistence")
	EntityManager entity;

	public SessionBean() {
	}

	@Override
	public List<Contact> getAllContacts() {
		Query queryContacts = entity.createNamedQuery("contacts");
		List<Contact> contact = queryContacts.getResultList();
		return contact;
	}

	@Override
	public Contact getById(Long id) {
		Contact contact = entity.find(Contact.class, id);
		return contact;
	}

	@Override
	public void addContact(Contact contact) {
		entity.persist(contact);
	}

	@Override
	public List<Contact> getContactByLastname(String lastName) {
		Query queryLastname = entity.createNamedQuery("contactLastname");
		queryLastname.setParameter("lastName", lastName);
		List<Contact> contact = (List<Contact>) queryLastname.getResultList();
		return contact;
	}

	@Override
	public List<Contact> getContactByNumber(String number) {
		Query queryNumber = entity.createNamedQuery("contactNumber");
		queryNumber.setParameter("number", number);
		List<Contact> contact = (List<Contact>) queryNumber.getResultList();
		return contact;
	}

	@Override
	public void updateContact(Contact contact) {
		entity.merge(contact);
	}

	@Override
	public void deleteContact(Long id) {
		Contact contact = entity.find(Contact.class, id);
		if (contact == null) {
			System.out.println("An error has occurred");
		}
		entity.remove(contact);
	}

}
