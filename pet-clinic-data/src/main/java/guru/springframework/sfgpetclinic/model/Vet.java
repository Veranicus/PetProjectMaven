package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by jt on 7/13/18.
 */
@Data
@NoArgsConstructor
public class Vet extends Person {

    private Set<Speciality> specialities;

}
