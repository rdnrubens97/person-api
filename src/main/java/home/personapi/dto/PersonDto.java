package home.personapi.dto;

import home.personapi.entity.Phone;
import lombok.*;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String cpf;
    private String birthDate;
    private List<Phone> phones;

    @Override
    public String toString(){
        return "Person: " +
                "\nName: " + firstName + " " + lastName +
                "\nCPF: " + cpf +
                "\nBirth Date: " + birthDate +
                "\nPhones: " + phones + ".";
    }

}
