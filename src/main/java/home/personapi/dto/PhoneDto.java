package home.personapi.dto;

import home.personapi.enums.PhoneType;
import lombok.Data;

@Data
public class PhoneDto {
    private Long id;
    private PhoneType type;
    private String number;
}
