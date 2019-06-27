package guru.springframework.sfgpetclinic.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by jt on 7/13/18.
 */
@MappedSuperclass
@Data
public class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
