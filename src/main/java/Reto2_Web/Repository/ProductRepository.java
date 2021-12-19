package Reto2_Web.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import Reto2_Web.Repository.CrudRepository.ProductCrudRepository;
import Reto2_Web.modelo.Product;

public class ProductRepository {
    
    @Autowired
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){
        return (List<Product>) productCrudRepository.findAll();
    }

    public Optional<Product> getProduct(Integer id){
        return productCrudRepository.findById(id);
    }

    public Product save (Product product){
        return productCrudRepository.save(product);
    }
    
    public void update(Product product){
        productCrudRepository.save(product);
    }

    public void delete(Product product){
        productCrudRepository.delete(product);
    }

}
