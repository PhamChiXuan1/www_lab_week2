package vn.edu.iuh.fit.labweek2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.labweek2.models.ProductPrice;

import java.util.List;
import java.util.Optional;

public class ProductPriceRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public ProductPriceRepository(){
        em = Persistence.createEntityManagerFactory("lab-week-2").createEntityManager();
        transaction = em.getTransaction();
    }

    public void insert(ProductPrice productPrice){
        try {
            transaction.begin();
            em.persist(productPrice);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<ProductPrice> getAll(){
        return em.createNamedQuery("ProductPrice.findAll", ProductPrice.class).getResultList();
    }

    public Optional<ProductPrice> findById(long id){
        TypedQuery<ProductPrice> query = em.createQuery("Select ProductPrice .priceDateTime, ProductPrice .note, ProductPrice .price, ProductPrice .product.id from ProductPrice inner join Product  on ProductPrice .product.id = Product .id where ProductPrice .product.id = :id", ProductPrice.class);
        query.setParameter("id", id);
        ProductPrice productPrice = query.getSingleResult();
        return productPrice == null ? Optional.empty() : Optional.of(productPrice);
    }
}
