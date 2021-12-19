package Reto2_Web.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Reto2_Web.modelo.Product;
import Reto2_Web.servicio.ProductService;

@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})

public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Product product){
        productService.save(product);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return productService.delete(id);
    }
    
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id")Integer id){
        return productService.getProduct(id);  
    }

}
