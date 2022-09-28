package tr.com.calik.app.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tr.com.calik.app.graphql.dto.PersonDto;
import tr.com.calik.app.graphql.entity.Person;
import tr.com.calik.app.graphql.repository.PersonRepository;

@Component
@RequiredArgsConstructor
public class PersonMutationResolver implements GraphQLMutationResolver {

    private final PersonRepository personRepository;

    public PersonDto createPerson(String email) {
        Person person = new Person();
        person.setEmail(email);
        person = personRepository.save(person);
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setEmail(person.getEmail());
        return personDto;
    }
}