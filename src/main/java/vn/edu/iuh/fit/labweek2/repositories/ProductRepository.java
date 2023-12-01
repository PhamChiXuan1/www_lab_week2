package vn.edu.iuh.fit.labweek2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.labweek2.enums.ProductStatus;
import vn.edu.iuh.fit.labweek2.models.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private EntityManager cus;
    private EntityTransaction transaction;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public ProductRepository(){
        cus = Persistence.createEntityManagerFactory("lab-week-2").createEntityManager();
        transaction = cus.getTransaction();
    }
    public void insertProduct(Product product){
        try {
            transaction.begin();
            cus.persist(product);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    public void setStatus(Product product, ProductStatus productStatus){
        product.setStatus(productStatus);
    }
    public void updateProduct(Product product){
        try {
            transaction.begin();
            cus.merge(product);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    public Optional<Product> findById(long id){
        TypedQuery<Product> query = cus.createQuery("select p from Product p where p.id = :id", Product.class);
        query.setParameter("id", id);
        Product product = query.getSingleResult();
        return product == null ? Optional.empty():Optional.of(product);
    }
    public List<Product> getAll(){
        return cus.createNamedQuery("Product.findAll", Product.class).setParameter(1, ProductStatus.ACTIVE).getResultList();
    }
}
