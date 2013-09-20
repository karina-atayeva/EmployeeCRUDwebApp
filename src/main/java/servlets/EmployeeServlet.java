package servlets;

import beans.EmployeeBeanInterface;
import models.Employee;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

    @EJB
    private EmployeeBeanInterface employeeBeanInterface;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String employeeIdStr = request.getParameter("employeeId");
        int employeeId = 0;
        if(employeeIdStr!=null && !employeeIdStr.equals("")){
            employeeId=Integer.parseInt(employeeIdStr);
        }
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String position = request.getParameter("position");
        Employee employee = new Employee(employeeId, firstName, lastName, position);

        if("Add".equalsIgnoreCase(action)){
            employeeBeanInterface.addEmployee(employee);
        }else if("Edit".equalsIgnoreCase(action)){
            employeeBeanInterface.editEmployee(employee);
        }else if("Delete".equalsIgnoreCase(action)){
            employeeBeanInterface.deleteEmployee(employeeId);
        }else if("GetByID".equalsIgnoreCase(action)){
            employee = employeeBeanInterface.getEmployeeById(employeeId);
        }
        request.setAttribute("employee", employee);
        request.setAttribute("allEmployees", employeeBeanInterface.getAllEmployees());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
