package Reto2_Web.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Reto2_Web.Repository.ProductRepository;
import Reto2_Web.modelo.Product;

@Service
public class ProductService {
    
    @Autowired

    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(Integer id){
        return productRepository.getProduct(id);
    }

    public Product save(Product product){
        if(product.getId() == null) {
            return product;
        }else{
            return productRepository.save(product);
        }
    }

    public Product update(Product product) {

        if (product.getId() != null) {
            Optional<Product> dbProduct = productRepository.getProduct(product.getId());
            if (!dbProduct.isEmpty()) {
                if (product.getBrand() != null) {
                    dbProduct.get().setBrand(product.getBrand());
                }
                if (product.getCategory() != null) {
                    dbProduct.get().setCategory(product.getCategory());
                }
                if (product.getName() != null) {
                    dbProduct.get().setName(product.getName());
                }
                if (product.getDescription() != null) {
                    dbProduct.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    dbProduct.get().setPhotography(product.getPhotography());
                }
                dbProduct.get().setAvailability(product.isAvailability());
                productRepository.update(dbProduct.get());
                return dbProduct.get();      
            } else {
                return product;
            }
        }else{
            return product;
        }

    }

    public boolean delete(Integer id){
        return getProduct(id).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElse(false);
    }



}
