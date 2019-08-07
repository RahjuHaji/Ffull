/**
 * @author Cobetuoiteen <tienhuynhq5@gmail.com>
 * @dateCreate Aug 2, 2019
 */
package tien.Ffull.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @TODO
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName, lastName;
	
//	We can see that there is something wrong, and the
//	application seems to be in an infinite loop. This happens on account of our oneto-
//	many relationship between the car and owner tables. So, what happens in
//	practice? First, the car is serialized, and it contains an owner who is then
//	serialized, and that, in turn, contains cars that are then serialized and so on. To
//	avoid this, we have to add the @JsonIgnore annotation to the cars field in
//	the Owner class:
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	@JsonIgnore
	private List<Car> cars;
	
	/**
	 */
	public Owner() {}

	/**
	 * @param firstName
	 * @param lastName
	 */
	public Owner(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the cars
	 */
	public List<Car> getCars() {
		return cars;
	}

	/**
	 * @param cars the cars to set
	 */
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
