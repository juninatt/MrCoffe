package se.pbt.mrcoffee.model.contact;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import se.pbt.mrcoffee.model.user.MrCoffeeUser;

import java.util.Objects;

/**
 * Represents contact information of a supplier.
 * <p>
 * This class extends the {@link Contact} base class and includes additional details
 * specific to a supplier, such as the company name and industry.
 * <p>
 * These details are essential for differentiating and managing suppliers within
 * the system.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class SupplierContact extends Contact {

    @NotBlank(message = "Company name is required")
    @Size( max = 30, message = "Company name cant be more than 30 characters")
    private String companyName;

    @NotBlank(message = "Industry is required")
    @Size( max = 30, message = "Industry be more than 30 characters")
    private String industry;

    public SupplierContact() {}

    public SupplierContact(String email, String phoneNumber, String additionalInfo, MrCoffeeUser mrCoffeeUser, String companyName, String industry) {
        super(email, phoneNumber, additionalInfo, mrCoffeeUser);
        this.companyName = companyName;
        this.industry = industry;
    }

    // Getters and setters

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    // Overridden methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SupplierContact that = (SupplierContact) o;
        return Objects.equals(companyName, that.companyName) &&
                Objects.equals(industry, that.industry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), companyName, industry);
    }
}
