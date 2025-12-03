package com.asafeorneles.cadastro_pets_crud.specifications;

import com.asafeorneles.cadastro_pets_crud.entities.Pet;
import com.asafeorneles.cadastro_pets_crud.enums.Sexo;
import com.asafeorneles.cadastro_pets_crud.enums.Tipo;
import com.asafeorneles.cadastro_pets_crud.repositories.PetReposirory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PetSpecificationTest {

//    private List<Pet> pets;
//    @BeforeEach
//    void setUp(){
//        pets = new ArrayList<>();
//    }

    @Autowired
    PetReposirory petReposirory;

    @Nested
    class haveType {
        @Test
        void shouldFindPetByTypeWithSuccess() {
            var petGato = Pet.builder().type(Tipo.GATO).build();
            var petCachorro = Pet.builder().type(Tipo.CACHORRO).build();
            petReposirory.save(petGato);
            petReposirory.save(petCachorro);
            Specification<Pet> dogSpec = PetSpecification.haveType("cachorro");
            Specification<Pet> catSpec = PetSpecification.haveType("gato");

            List<Pet> petsFound1 = petReposirory.findAll(dogSpec);
            List<Pet> petsFound2 = petReposirory.findAll(catSpec);

            assertFalse(petsFound1.isEmpty());
            assertEquals(Tipo.CACHORRO, petsFound1.get(0).getType());
            assertEquals(1, petsFound1.size());
            assertNotEquals(Tipo.GATO, petsFound1.get(0).getType());

            assertFalse(petsFound2.isEmpty());
            assertEquals(Tipo.GATO, petsFound2.get(0).getType());
            assertEquals(1, petsFound2.size());
            assertNotEquals(Tipo.CACHORRO, petsFound2.get(0).getType());
        }
        
        @Test
        void shouldReturnAllPetsWhenParamIsNull(){
            var petGato = Pet.builder().type(Tipo.GATO).build();
            var petCachorro = Pet.builder().type(Tipo.CACHORRO).build();
            petReposirory.save(petGato);
            petReposirory.save(petCachorro);

            List<Pet> petsFound = petReposirory.findAll(PetSpecification.haveType(null));

            assertFalse(petsFound.isEmpty());
            assertEquals(2, petsFound.size());
        }

        @Test
        void shouldReturnOneListEmptyWhenPetIsNotFoundByType() {
            Specification<Pet> dogSpec = PetSpecification.haveType("cachorro");
            Specification<Pet> catSpec = PetSpecification.haveType("gato");

            List<Pet> petsFound1 = petReposirory.findAll(dogSpec);
            List<Pet> petsFound2 = petReposirory.findAll(catSpec);

            assertTrue(petsFound1.isEmpty());
            assertTrue(petsFound2.isEmpty());
        }
    }


    @Nested
    class haveSex {
        @Test
        void shouldFindPetByTypeWithSuccess() {
            var petFemea = Pet.builder().sexo(Sexo.FEMININO).build();
            var petMacho = Pet.builder().sexo(Sexo.MASCULINO).build();
            petReposirory.save(petFemea);
            petReposirory.save(petMacho);
            Specification<Pet> femSpec = PetSpecification.haveSex("femea");
            Specification<Pet> mascSpec = PetSpecification.haveSex("macho");

            List<Pet> petsFound1 = petReposirory.findAll(femSpec);
            List<Pet> petsFound2 = petReposirory.findAll(mascSpec);

            assertFalse(petsFound1.isEmpty());
            assertEquals(Sexo.FEMININO, petsFound1.get(0).getSexo());
            assertEquals(1, petsFound1.size());
            assertNotEquals(Sexo.MASCULINO, petsFound1.get(0).getSexo());

            assertFalse(petsFound2.isEmpty());
            assertEquals(Sexo.MASCULINO, petsFound2.get(0).getSexo());
            assertEquals(1, petsFound2.size());
            assertNotEquals(Sexo.FEMININO, petsFound2.get(0).getSexo());
        }

        @Test
        void shouldReturnAllPetsWhenParamIsNull(){
            var petFemea = Pet.builder().sexo(Sexo.FEMININO).build();
            var petMacho = Pet.builder().sexo(Sexo.MASCULINO).build();
            petReposirory.save(petFemea);
            petReposirory.save(petMacho);

            List<Pet> petsFound = petReposirory.findAll(PetSpecification.haveSex(null));

            assertFalse(petsFound.isEmpty());
            assertEquals(2, petsFound.size());
        }

        @Test
        void shouldReturnOneListEmptyWhenPetIsNotFoundByType() {
            Specification<Pet> femSpec = PetSpecification.haveSex("femea");
            Specification<Pet> mascSpec = PetSpecification.haveSex("macho");

            List<Pet> petsFound1 = petReposirory.findAll(femSpec);
            List<Pet> petsFound2 = petReposirory.findAll(mascSpec);

            assertTrue(petsFound1.isEmpty());
            assertTrue(petsFound2.isEmpty());
        }
    }

    @Test
    void nameContains() {
    }

    @Test
    void equalsAge() {
    }
}