package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogsRepository extends JpaRepository<Dog, Long> {
//    long save(Dog theDog );
    Dog  findById( long id );
    List<Dog> findByName(Dog theDog );
    void delete(Dog theDog );
    long count();
    boolean existsById( long id );

    // Additional admin functionality
    void    deleteAll();

//    List<Dog> findAll();
}
