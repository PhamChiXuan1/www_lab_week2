package vn.edu.iuh.fit.labweek2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.labweek2.enums.EmployeeStatus;
import vn.edu.iuh.fit.labweek2.models.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private EntityManager cus;
    private EntityTransaction transaction;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public EmployeeRepository(){
        cus = Persistence.createEntityManagerFactory("lab-week-2").createEntityManager();
        transaction = cus.getTransaction();
    }
    public void insertEmp(Employee employee){
        try {
            transaction.begin();
            cus.persist(employee);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    public void updateEmp(Employee employee){
        try {
            transaction.begin();
            cus.merge(employee);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public void setStatus(Employee employee, EmployeeStatus employeeStatus){
        employee.setStatus(employeeStatus);
    }
    public Optional<Employee> findById(long id){
        TypedQuery<Employee> query = cus.createQuery("select e from Employee e where e.id = :id", Employee.class);
        query.setParameter("id", id);
        Employee employee = query.getSingleResult();
        return employee == null ? Optional.empty():Optional.of(employee);
    }
    public List<Employee> getAllEmp(){
        return cus.createNamedQuery("Employee.findAll", Employee.class).setParameter(1, EmployeeStatus.ACTIVE).getResultList();
    }
}
