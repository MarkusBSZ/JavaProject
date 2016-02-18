package auction;

import javax.persistence.*;

@Entity
@Table(name="NAME")
public class Name implements IName {
	
	public Name() {
		super();
	}
	public Name(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/* (non-Javadoc)
	 * @see auction.IName#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see auction.IName#getFirstName()
	 */
	@Override
	public String getFirstName() {
		return firstName;
	}

	/* (non-Javadoc)
	 * @see auction.IName#getLastName()
	 */
	@Override
	public String getLastName() {
		return lastName;
	}

	/* (non-Javadoc)
	 * @see auction.IName#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see auction.IName#setFirstName(java.lang.String)
	 */
	@Override
	public IName setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/* (non-Javadoc)
	 * @see auction.IName#setLastName(java.lang.String)
	 */
	@Override
	public IName setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/* (non-Javadoc)
	 * @see auction.IName#toString()
	 */
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	@Id
	@Column(name="NAME_ID",columnDefinition= "NUMBER (4,0)")
	private Long id = Long.valueOf(1);
	
	@Column(name="FIRSTNAME",columnDefinition= "VARCHAR2 (24)")
	private String firstName;

	@Column(name="LASTNAME",columnDefinition= "VARCHAR2 (24)")
	private String lastName;
}
