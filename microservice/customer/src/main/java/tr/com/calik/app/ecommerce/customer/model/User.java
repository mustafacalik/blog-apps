package tr.com.calik.app.ecommerce.customer.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="users")
public class User extends PanacheMongoEntity {

    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String address;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
    }
}
