package beans;

import models.Employee;

import javax.ejb.Local;
import java.util.List;

@Local
public interface EmployeeBeanInterface {
    void addEmployee(Employee employee);

    Employee getEmployeeById(int employeeId);

    List<Employee> getAllEmployees();

    void editEmployee(Employee employee);

    void deleteEmployee(int employeeId);
}
