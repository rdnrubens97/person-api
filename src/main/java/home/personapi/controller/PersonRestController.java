package home.personapi.controller;

import home.personapi.dto.PersonDto;
import home.personapi.entity.Person;
import home.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/people")
public class PersonRestController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok().body(personService.test());
    }

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody Person person){
        personService.createPerson(person);
        return ResponseEntity.ok().body(personService.createPerson(person));
    }

}
