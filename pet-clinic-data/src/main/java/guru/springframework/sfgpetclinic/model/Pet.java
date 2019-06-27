package guru.springframework.sfgpetclinic.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by jt on 7/13/18.
 */
@Data
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @Column(name = "owner")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth:_data")
    private LocalDate birthDate;

}
