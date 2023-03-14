package home.personapi.dto;

import home.personapi.entity.Phone;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PersonDto {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private List<Phone> phones;

    @Override
    public String toString(){
        return "Person {" +
                "\nName: " + firstName + " " + lastName +
                "\nBirth Date: " + birthDate +
                "\nPhone(s)" + phones;
    }

}
