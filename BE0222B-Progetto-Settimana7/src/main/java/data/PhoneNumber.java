package data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@NamedQuery(name = "contactNumber", query = "select c from Contact c where c.phoneNumbers = "
		+ "any(select n from PhoneNumber n where n.phoneNumbers = :number)")
public class PhoneNumber {
	private Long idPhoneNumber;
	private String phoneNumbers;
	private Contact contact;

	public PhoneNumber(String phoneNumbers, Contact contact) {
		super();
		this.phoneNumbers = phoneNumbers;
		this.contact = contact;
	}

	public PhoneNumber() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdPhoneNumber() {
		return idPhoneNumber;
	}

	public void setIdPhoneNumber(Long idPhoneNumber) {
		this.idPhoneNumber = idPhoneNumber;
	}

	@Column(name = "phoneNumbers", unique = true, nullable = false)
	public String getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
