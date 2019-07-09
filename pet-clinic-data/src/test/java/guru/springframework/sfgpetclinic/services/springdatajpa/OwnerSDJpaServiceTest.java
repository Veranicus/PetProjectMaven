package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Homp";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        Mockito.when(ownerRepository.findByLastName(Mockito.any())).thenReturn(returnedOwner);

        Owner homp = ownerSDJpaService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, homp.getLastName());

        Mockito.verify(ownerRepository).findByLastName(Mockito.any());
    }

    @Test
    void findAll() {
        Set<Owner> returnedOwners = new HashSet<>();
        returnedOwners.add(Owner.builder().id(1l).build());
        returnedOwners.add(Owner.builder().id(2l).build());

        Mockito.when(ownerRepository.findAll()).thenReturn(returnedOwners);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {

        Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(returnedOwner));

        Owner owner = ownerSDJpaService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {

        Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerSDJpaService.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        Mockito.when(ownerRepository.save(Mockito.any())).thenReturn(returnedOwner);

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);

        Mockito.verify(ownerRepository).save(Mockito.any());

    }

    @Test
    void delete() {

        ownerSDJpaService.delete(returnedOwner);

        Mockito.verify(ownerRepository, Mockito.times(1)).delete(Mockito.any());


    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        Mockito.verify(ownerRepository).deleteById(Mockito.anyLong());

    }
}
