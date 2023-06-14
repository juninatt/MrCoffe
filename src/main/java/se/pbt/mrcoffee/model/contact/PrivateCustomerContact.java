package se.pbt.mrcoffee.model.contact;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import se.pbt.mrcoffee.model.user.MrCoffeeUser;

/**
 * Represents contact information for a private customer.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PrivateCustomerContact extends Contact {

    @Column(name = "first_name")
    @NotBlank(message = "First name is required")
    @Size(max = 25, message = "Cant be longer than 25 characters")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name is required")
    @Size(max = 30, message = "Cant be longer than 30 characters")
    private String lastName;

    /**
     * Default constructor for the PrivateCustomerContact class.
     */
    public PrivateCustomerContact() {
    }

    /**
     * Constructor for the PrivateCustomerContact class.
     *
     * @param email           The email address of the private customer.
     * @param phoneNumber     The phone number of the private customer.
     * @param additionalInfo  Additional information about the private customer.
     * @param mrCoffeeUser            The user associated with the private customer.
     * @param firstName       The first name of the private customer.
     * @param lastName        The last name of the private customer.
     */
    public PrivateCustomerContact(String email, String phoneNumber, String additionalInfo, MrCoffeeUser mrCoffeeUser, String firstName, String lastName) {
        super(email, phoneNumber, additionalInfo, mrCoffeeUser);
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}