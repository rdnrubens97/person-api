package home.personapi.service;

import home.personapi.dto.PersonDto;
import home.personapi.entity.Person;
import home.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public String test(){
        return "Testing our business model" ;
    }

    public PersonDto createPerson(Person person){
        personRepository.save(person);
        PersonDto personDto = entityToDto(person);
        return personDto;
    }

    public PersonDto entityToDto(Person entity){
        PersonDto personDto = new PersonDto();
        personDto.setFirstName(entity.getFirstName());
        personDto.setLastName(entity.getLastName());
        personDto.setBirthDate(entity.getBirthDate());
        personDto.setPhones(entity.getPhones());
        return personDto;
    }

}
