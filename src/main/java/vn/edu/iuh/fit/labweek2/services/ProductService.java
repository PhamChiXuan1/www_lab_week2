package vn.edu.iuh.fit.labweek2.services;

import vn.edu.iuh.fit.labweek2.enums.ProductStatus;
import vn.edu.iuh.fit.labweek2.models.Product;
import vn.edu.iuh.fit.labweek2.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private ProductRepository productRepository;
    public ProductService(){
        productRepository = new ProductRepository();
    }

    public void insert(Product product){
        productRepository.insertProduct(product);
    }

    public Optional<Product> findById(long id){
        return productRepository.findById(id);
    }

    public void update(Product product){
        productRepository.updateProduct(product);
    }

    public boolean delete(long id){
        Optional<Product> op = findById(id);
        if(op.isPresent()){
            Product product = op.get();
            product.setStatus(ProductStatus.TERMINATED);
            productRepository.updateProduct(product);
            return true;
        }
        return false;
    }

    public boolean acticeProduct(long id){
        Optional<Product> op = findById(id);
        if(op.isPresent()){
            Product product = op.get();
            product.setStatus(ProductStatus.ACTIVE);
            return true;
        }
        return false;
    }
    public List<Product> getAll(){
        return productRepository.getAll();
    }
}
