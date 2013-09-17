package beans;

import models.Employee;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Karina
 * Date: 13.16.9
 * Time: 01:24
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface EmployeeBeanInterface {
    void addEmployee(Employee employee);

    Employee getEmployeeById(int employeeId);

    List<Employee> getAllEmployees();

    void editEmployee(Employee employee);

    void deleteEmployee(int employeeId);
}
