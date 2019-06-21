package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by jt on 7/25/18.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petType) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petType;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType saveCatType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogType = petTypeService.save(dog);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("827 Boston");
        owner1.setCity("Boston");
        owner1.setTelephone("98988668");

        Pet michaelPet = new Pet();
        michaelPet.setName("Doggo");
        michaelPet.setPetType(saveDogType);
        michaelPet.setOwner(owner1);
        michaelPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(michaelPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner1.setAddress("312č Boulevard");
        owner1.setCity("New York");
        owner1.setTelephone("7867868");

        Pet fionasPet = new Pet();
        fionasPet.setName("Fred");
        fionasPet.setPetType(saveCatType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasPet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
