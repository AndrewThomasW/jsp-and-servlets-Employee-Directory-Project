package andrew.thomas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import andrew.thomas.dao.EmployeeDAOImpl;
import andrew.thomas.entity.Employee;

public class EmployeeServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeServletController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null)
			action = "LIST";

		switch (action) {
		case "LIST":
			listEmployees(request, response);
			break;
		case "EDIT":
			editEmployee(request, response);
			break;
		case "DELETE":
			deleteEmployee(request, response);
			break;
		default:
			listEmployees(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String department = request.getParameter("department");
		String id = request.getParameter("id");
		
		System.out.println(id);
		
		if (id == null || id.isEmpty()) {
			Employee emp = new Employee(name, dob, department);

			EmployeeDAOImpl dao = new EmployeeDAOImpl();
			if (dao.addEmployee(emp)) {
				request.setAttribute("message", "Employee added sucessfully !!");
			} else {
				request.setAttribute("message", "operation not successful");
			}
			
		}else {
			Employee emp = new Employee(Integer.parseInt(id),name, dob, department);
			System.out.println(emp);
			EmployeeDAOImpl dao = new EmployeeDAOImpl();
			if (dao.updateEmployee(emp)) {
				request.setAttribute("message", "Employee edited sucessfully !!");
			} else {
				request.setAttribute("message", "operation not successful");
			}
		}

		listEmployees(request, response);
	}

	protected void listEmployees(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setting request object attributes
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		List<Employee> emps = dao.getEmployees();
		request.setAttribute("employees", emps);

		// dispatch req and resp object into another component
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/employee-list.jsp");
		dispatcher.forward(request, response);
	}

	protected void editEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		Employee emp = dao.getEmployee(Integer.parseInt(request.getParameter("id")));
		
		//set request object attributes
		request.setAttribute("employee", emp);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/employee-edit.jsp");
		dispatcher.forward(request, response);

	}
	
	protected void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		//getEmployee
		String id = request.getParameter("id");
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		Employee e = dao.getEmployee(Integer.parseInt(id));
		
		if(dao.deleteEmployee(e)) {
			request.setAttribute("message", "Employee deleted successfully !");
		}else {
			request.setAttribute("message", "operation not successful");
		}
		
		try {
			listEmployees(request, response);
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}



















