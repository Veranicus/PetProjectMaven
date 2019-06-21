package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 7/13/18.
 */
@Data
@NoArgsConstructor
public class Owner extends Person {


    private String address;
    private String city;
    private String telephone;

    private Set<Pet> pets = new HashSet<>();

}
