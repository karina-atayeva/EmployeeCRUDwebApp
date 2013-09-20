package beans;

import models.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless(name = "EmployeeEJB")
public class EmployeeBean implements EmployeeBeanInterface {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return entityManager.createNamedQuery("Employee.getAll").getResultList();
    }

    @Override
    public void editEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        entityManager.remove(getEmployeeById(employeeId));
    }
}
