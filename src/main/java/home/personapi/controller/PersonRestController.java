package home.personapi.controller;

import home.personapi.dto.PersonDto;
import home.personapi.exception.PersonNotFoundException;
import home.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonRestController {
    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PersonDto> createPerson(@RequestBody @Validated PersonDto personDto){
        return ResponseEntity.ok().body(personService.createPerson(personDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonDto> updatePersonById(@PathVariable Long id, @RequestBody PersonDto personDto) throws PersonNotFoundException {
        return ResponseEntity.ok().body(personService.updatePersonById(id, personDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> listAllPersons(){
        return ResponseEntity.ok().body(personService.listAllPersons());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable Long id) throws PersonNotFoundException {
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
