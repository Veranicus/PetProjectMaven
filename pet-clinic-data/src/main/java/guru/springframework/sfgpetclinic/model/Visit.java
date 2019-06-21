package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Visit extends BaseEntity {

    private LocalDate localDate;
    private String description;
    private Pet pet;


}
