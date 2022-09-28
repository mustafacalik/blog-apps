package tr.com.calik.app.ecommerce.customer.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import tr.com.calik.app.ecommerce.customer.model.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {

    public Optional<User> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }
}
