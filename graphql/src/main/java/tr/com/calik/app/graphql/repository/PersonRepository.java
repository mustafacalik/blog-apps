package tr.com.calik.app.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.calik.app.graphql.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}