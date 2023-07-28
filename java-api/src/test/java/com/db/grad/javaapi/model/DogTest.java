package com.db.grad.javaapi.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DogTest {
    @Test
    public void testUpdateDogDetails() {
        Dog originalDog = new DogsHandler();
        originalDog.setId(1);
        Dog updatedDog = new DogsHandler();
        updatedDog.setId(1);

        long updatedDogId = originalDog.updateDogDetails(updatedDog);
        Assertions.assertEquals(1, updatedDogId);
    }
}