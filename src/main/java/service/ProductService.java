package service;

import entity.Product;
import org.springframework.stereotype.Service;
import repo.ProductRepo;
import repo.ProductRepo;

import java.util.List;

@Service
public class ProductService {

    private ProductRepo productRepo;

    public void createProduct(Product Product){
        productRepo.save(Product);
    }

    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    public Product getProductById(Long id){
        return productRepo.findById(id).orElseThrow( () -> new RuntimeException("Product with id" + id+ " not found"));
    }

    public void updateProduct(Product Product){
        productRepo.findById(Product.getId()).orElseThrow( () -> new RuntimeException("Product with id" + Product.getId()+ " not found"));
        productRepo.save(Product);
    }

    public void deleteProduct(Long id){
        productRepo.findById(id).orElseThrow( () -> new RuntimeException("Product with id" + id+ " not found"));
        productRepo.deleteById(id);
    }

    public Product findProductByName(String name){
        return productRepo.findByName(name);
    }
}
