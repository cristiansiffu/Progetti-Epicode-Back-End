package data;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@NamedQuery(name = "contacts", query = "select c from Contact c")
@NamedQuery(name = "contactLastname", query = "select c from Contact c where c.lastName = :lastName")

public class Contact {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private List<PhoneNumber> phoneNumbers;

	public Contact(String firstName, String lastName, String email, List<PhoneNumber> phoneNumbers) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
	}

	public Contact() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, phoneNumbers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phoneNumbers, other.phoneNumbers);
	}

	@Override
	public String toString() {
		String info = "/r/n" + "FirstName: " + firstName + 
				"/r/n" + "LastName: " + lastName +
				"/r/n" + "E-mail=" + email
				+ "/r/n" + "Number 1: " + this.getPhoneNumbers().get(0).getPhoneNumbers() + 
				"/r/n";
		if (this.getPhoneNumbers().size() > 1) {
			info += "Number 2: " + this.getPhoneNumbers().get(1).getPhoneNumbers();
		}
		return info;
	}

}
