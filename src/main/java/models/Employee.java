package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="EMPLOYEE")
@NamedQueries(@NamedQuery(name="Employee.getAll", query="SELECT employee FROM Employee employee"))
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "POSITION")
    private String position;

    public Employee() {}

    public Employee(int employeeId, String firstName, String lastName, String position) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
