package tr.com.calik.app.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import tr.com.calik.app.graphql.dto.PersonDto;
import tr.com.calik.app.graphql.entity.Person;
import tr.com.calik.app.graphql.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {

    private final PersonRepository personRepository;

    public PersonDto personById(Long id) {
        Person person = personRepository.findById(id).get();
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setEmail(personDto.getEmail());
        return personDto;
    }

    public List<PersonDto> persons() {
        return personRepository.findAll().stream().map(person -> personToDto(person)).collect(Collectors.toList());
    }

    private PersonDto personToDto(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setEmail(person.getEmail());
        return personDto;
    }

}