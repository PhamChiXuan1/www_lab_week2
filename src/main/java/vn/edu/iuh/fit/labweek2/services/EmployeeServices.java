package vn.edu.iuh.fit.labweek2.services;

import vn.edu.iuh.fit.labweek2.enums.EmployeeStatus;
import vn.edu.iuh.fit.labweek2.models.Employee;
import vn.edu.iuh.fit.labweek2.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    private EmployeeRepository employeeRepository;
    public EmployeeServices(){
        employeeRepository = new EmployeeRepository();
    }
    public void insertEmp(Employee employee){
        employeeRepository.insertEmp(employee);
    }
    public Optional<Employee> findById(long id){
        return employeeRepository.findById(id);
    }

    public void update(Employee employee){
        employeeRepository.updateEmp(employee);
    }

    public boolean delete(long id){
        Optional<Employee> op = findById(id);
        if(op.isPresent()){
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.TERMINATED);
            employeeRepository.updateEmp(employee);
            return true;
        }
        return false;
    }

    public boolean activeEmp(long id){
        Optional<Employee> op = findById(id);
        if(op.isPresent()){
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public List<Employee> getAll(){
        return employeeRepository.getAllEmp();
    }
}
