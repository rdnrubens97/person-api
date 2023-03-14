package home.personapi.service;

import home.personapi.dto.PersonDto;
import home.personapi.entity.Person;
import home.personapi.exception.PersonNotFoundException;
import home.personapi.mapper.PersonMapper;
import home.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public PersonDto createPerson(PersonDto personDto) {
        Person person = personMapper.toModel(personDto);
        personRepository.save(person);
        PersonDto personDto1 = personMapper.toDto(person);
        return personDto1;
    }

    public List<PersonDto> listAllPersons() {
        return personRepository.findAll()
                .stream()
                .map(model -> personMapper.toDto(model))
                .collect(Collectors.toList());
    }

    public PersonDto findById(Long id) throws PersonNotFoundException {
        Person person = verifyExists(id);
        return personMapper.toDto(person);
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        verifyExists(id);
        personRepository.deleteById(id);
    }

    private Person verifyExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }





}
