package auction;

public interface IName {

	boolean equals(Object obj);

	String getFirstName();

	String getLastName();

	int hashCode();

	IName setFirstName(String firstName);

	IName setLastName(String lastName);

	String toString();

}