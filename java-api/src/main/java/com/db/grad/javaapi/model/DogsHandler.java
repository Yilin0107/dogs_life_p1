package com.db.grad.javaapi.model;

import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;

public class DogsHandler {
    private DogsRepository itsDog;

    public DogsHandler(DogsRepository repo) {
        this.itsDog = repo;
    }

    public long addDog(Dog theDog) {
        try {
            itsDog.save(theDog);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public long getNoOfDogs() {
        return itsDog.count();
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
}
