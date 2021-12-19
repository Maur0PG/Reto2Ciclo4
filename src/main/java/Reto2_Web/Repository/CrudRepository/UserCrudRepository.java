package Reto2_Web.Repository.CrudRepository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import Reto2_Web.modelo.User;

public interface UserCrudRepository extends MongoRepository<User, Integer> {
    
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByNameOrEmail(String name, String email);
    
}
