package se.pbt.mrcoffee.integrationtest.testobject;

import se.pbt.mrcoffee.dto.request.CustomerContactDTO;
import se.pbt.mrcoffee.enums.CustomerLevel;
import se.pbt.mrcoffee.model.adress.Address;
import se.pbt.mrcoffee.dto.request.AddressDTO;
import se.pbt.mrcoffee.dto.response.AddressResponseDTO;
import se.pbt.mrcoffee.model.contact.CustomerContact;
import se.pbt.mrcoffee.model.contact.SupplierContact;
import se.pbt.mrcoffee.model.product.Coffee;
import se.pbt.mrcoffee.model.receipt.Receipt;
import se.pbt.mrcoffee.model.user.Customer;

import java.math.BigDecimal;

/**
 * Factory class to create test objects.
 */
public class TestObjectFactory {

    /**
     * @return A {@link Coffee} object with pre-set field values
     */
    public static Coffee createCoffee() {
        return new Coffee(
                "Americano",
                "Black",
                BigDecimal.valueOf(9.99),
                "America",
                "Dark",
                "Bitter",
                "Intense"
        );
    }

    public static Customer createCustomer() {
        return new Customer(
                "JamesGosling",
                "JamesGosling",
                CustomerLevel.VIP);
    }

    /**
     * @return A {@link Address} object with pre-set field values
     */
    public static Address createAddress() {
        return new Address(
                "Elm Street",
                1,
                1,
                "Göteborg",
                "12345",
                "Sweden"
        );
    }

    /**
     * @return A {@link AddressDTO} object with pre-set field values
     */
    public static AddressDTO createAddressDTO() {
        return new AddressDTO(
                "Elm Street",
                1,
                1,
                "Göteborg",
                "12345",
                "Sweden"
        );
    }

    /**
     * @return A {@link AddressResponseDTO} object with pre-set field values
     */
    public static AddressResponseDTO createAddressResponseDTO(long id) {
        return new AddressResponseDTO(
                id,
                "Elm Street",
                1,
                1,
                "Göteborg",
                "12345",
                "Sweden"
        );
    }

    /**
     * @return A {@link CustomerContact} object with pre-set field values
     */
    public static CustomerContact createCustomerContact() {
        return new CustomerContact(
                "james.gosling@coffee.se",
                "0735 666 666",
                "Apartment",
                null,
                "Petter",
                "Bergström"
        );
    }

    public static CustomerContactDTO createCustomerContactDTO() {
        return new CustomerContactDTO(
                "James",
                "Gosling",
                "james.gosling@coffee.se",
                "0735 666 666",
                "Apartment"
        );
    }

    /**
     * @return A {@link SupplierContact} object with pre-set field values
     */
    public static SupplierContact createSupplierContact() {
        return new SupplierContact(
               "nespresso@coffee.se",
               "031-12345",
               "Insolvent",
                null,
                "Nespresso",
                "Coffee"
        );
    }

    public static Receipt createReceipt() {
        return new Receipt(
                BigDecimal.valueOf(999.99),
                "Secret",
                BigDecimal.valueOf(9.99),
                "1"
        );
    }
}