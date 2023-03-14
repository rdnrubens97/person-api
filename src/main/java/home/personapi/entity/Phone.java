package home.personapi.entity;

import home.personapi.enums.PhoneType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    private Long id;
    private PhoneType type;
    private String number;

}
