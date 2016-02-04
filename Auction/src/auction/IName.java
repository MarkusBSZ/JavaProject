package auction;

public interface IName {

	boolean equals(Object obj);

	String getFirstName();

	String getLastName();

	int hashCode();

	void setFirstName(String firstName);

	void setLastName(String lastName);

	String toString();

}