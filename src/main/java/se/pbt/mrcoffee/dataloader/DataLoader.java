package se.pbt.mrcoffee.dataloader;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import se.pbt.mrcoffee.factory.UserFactory;
import se.pbt.mrcoffee.model.product.Coffee;
import se.pbt.mrcoffee.model.user.security.Role;
import se.pbt.mrcoffee.repository.RoleRepository;
import se.pbt.mrcoffee.repository.product.CoffeeRepository;
import se.pbt.mrcoffee.repository.user.UserRepository;

import java.math.BigDecimal;
import java.util.List;

@Component
class DataLoader {
    private final CoffeeRepository coffeeRepository;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DataLoader(CoffeeRepository coffeeRepository, UserRepository userRepository,
                      RoleRepository roleRepository) {
        this.coffeeRepository = coffeeRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void loadData() {
        loadTestStorage();
        var passWordEncoder = new BCryptPasswordEncoder();
        setTestUser(passWordEncoder);
    }

    private void setTestUser(BCryptPasswordEncoder passWordEncoder) {
        var adminRole = new Role("ROLE_ADMIN");
        roleRepository.save(adminRole);
        var userFactory = new UserFactory(roleRepository);
        var practiceUser = userFactory.createAdmin("admin", passWordEncoder.encode("admin"));
        userRepository.save(practiceUser);
    }

    private void loadTestStorage() {
        coffeeRepository.saveAll(List.of(
                new Coffee("Café Cereza", "Delicious Cereza Coffee", BigDecimal.valueOf(9.99), "Colombia", "Medium",
                        "Rich and fruity", "Medium"),
                new Coffee("Café Ganador", "Premium Ganador Coffee", BigDecimal.valueOf(12.99), "Brazil", "Dark",
                        "Intense and chocolatey", "High"),
                new Coffee("Café Lareño", "Lareño Coffee from Costa Rica", BigDecimal.valueOf(11.50), "Costa Rica",
                        "Medium", "Smooth and nutty", "Medium"),
                new Coffee("Café Três Pontas", "Três Pontas Brazilian Coffee", BigDecimal.valueOf(10.75), "Brazil",
                        "Medium-Dark", "Bold and caramel", "High"),
                new Coffee("Ethiopian Yirgacheffe", "Ethiopian Specialty Coffee", BigDecimal.valueOf(14.99), "Ethiopia",
                        "Light", "Floral and citrusy", "Low"),
                new Coffee("Sumatra Mandheling", "Indonesian Dark Roast Coffee", BigDecimal.valueOf(13.50), "Indonesia",
                        "Dark", "Earthy and full-bodied", "Medium"),
                new Coffee("Guatemala Antigua", "Single-Origin Guatemalan Coffee", BigDecimal.valueOf(12.75), "Guatemala",
                        "Medium-Dark", "Chocolate and spice", "Medium"),
                new Coffee("Costa Rica Tarrazu", "High-Quality Costa Rican Coffee", BigDecimal.valueOf(11.99), "Costa Rica",
                        "Medium", "Bright and balanced", "Medium"),
                new Coffee("Jamaican Blue Mountain", "Rare Jamaican Coffee", BigDecimal.valueOf(34.99), "Jamaica",
                        "Medium", "Mild and smooth", "Low"),
                new Coffee("Kenya AA", "Kenyan Specialty Coffee", BigDecimal.valueOf(15.25), "Kenya",
                        "Medium", "Wine-like acidity and fruity", "High")
        ));
    }
}
