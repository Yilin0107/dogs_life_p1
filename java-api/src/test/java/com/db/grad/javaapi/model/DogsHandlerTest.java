package com.db.grad.javaapi.model;

import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DogsHandlerTest {
    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);

        long expectedResult = 1;

        long actualResult = cut.getNoOfDogs();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void find_dog_by_valid_id_returns_null_dog() {
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        theDog = new Dog();
        theDog.setName("Frank");
        long uniqueId = cut.addDog(theDog);
        Dog expectedDog = theDog;
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog(theDog);

        Dog actualResult = cut.getDogById(33);

        assertNull(actualResult);
    }

    public void testRemoveDog() {
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);

        boolean actualResult = cut.removeDog(theDog);

        boolean expectedResult = true;

        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void find_dog_by_name_returns_one_dog() {

        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        theDog = new Dog();
        theDog.setName("Frank");
        cut.addDog(theDog);
        Dog expectedDog = theDog;
        String dogToFind = "Frank";
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog(theDog);

        Dog actualResult = cut.getDogByName(dogToFind);

        assertEquals(expectedDog.getName(), actualResult.getName());
    }

    @Test
    public void find_dog_by_name_returns_null_because_many_dogs_with_same_name() {
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        Dog expectedDog = theDog;
        String dogToFind = "Bruno";
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog(theDog);

        Dog actualResult = cut.getDogByName(dogToFind);

        assertNull(actualResult);

    }

    @Test
    public void update_dog_that_exists_returns_dog_id() {
        // arrange
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        theDog = new Dog();
        theDog.setName("Frank");
        long expectedResult = cut.addDog(theDog);
        Dog dogToUpdate = theDog;
        String dogToFind = "Frank";
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog(theDog);
        // act
        dogToUpdate.setName("Charlie");
        long actualResult = cut.updateDogDetails(dogToUpdate);

        // assert
        assertEquals(expectedResult, actualResult);
    }
}
