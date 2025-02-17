package com.db.grad.javaapi.model;

import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;

import java.util.ArrayList;
import java.util.Objects;

public class DogsHandler {
    private DogsRepository itsDog;

    public DogsHandler(DogsRepository repo) {
        this.itsDog = repo;
    }

    public long addDog(Dog theDog) {
        try {
            itsDog.save(theDog);
            return theDog.getId();
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public long getNoOfDogs() {
        return itsDog.count();
    }


    public Dog getDogById(long uniqueId){
        return itsDog.findById(uniqueId);
    }

    public boolean removeDog(Dog theDog) {
        try {
            itsDog.delete(theDog);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Dog getDogByName( String dogsName ) {
        Dog dogToFind = new Dog();
        dogToFind.setName(dogsName);
        ArrayList<Dog> dogs = (ArrayList<Dog>) itsDog.findByName(dogToFind);
        Dog result = null;

        if (dogs.size() == 1)
            result = dogs.get(0);

        return result;

    }

    public long updateDogDetails(Dog dog){
        try{
            Dog dogToUpdate = itsDog.findById(dog.getId());
            if (dogToUpdate == null){
                System.out.println("no such dog in the database");
                return -1;
            }
            else {
                dogToUpdate.setName(dog.getName());
                return dogToUpdate.getId();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}

