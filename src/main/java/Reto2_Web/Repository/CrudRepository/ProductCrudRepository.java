package Reto2_Web.Repository.CrudRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import Reto2_Web.modelo.Product;

public interface ProductCrudRepository extends MongoRepository<Product, Integer> {
    
}
