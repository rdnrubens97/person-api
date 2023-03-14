package home.personapi.service;

import home.personapi.dto.PersonDto;
import home.personapi.entity.Person;
import home.personapi.mapper.PersonMapper;
import home.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;


    public String test(){
        return "Testing our business model" ;
    }

    public PersonDto createPerson(PersonDto personDto){
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

    public PersonDto findById(Long id) {
        return personMapper.toDto(personRepository.findById(id).get());
    }
}
