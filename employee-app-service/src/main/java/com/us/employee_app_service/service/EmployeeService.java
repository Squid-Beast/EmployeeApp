package com.us.employee_app_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.employee_app_service.entity.Employee;
import com.us.employee_app_service.pojo.EmployeeDetails;
import com.us.employee_app_service.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

	public List<EmployeeDetails> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> {
            EmployeeDetails employeeDetails = new EmployeeDetails();
            employeeDetails.setFirstName(employee.getFirstName());
            employeeDetails.setLastName(employee.getLastName());
            employeeDetails.setJoiningDate(employee.getJoiningDate());
            employeeDetails.setRole(employee.getRole());
            return employeeDetails;
        }).toList();
	}

    public EmployeeDetails addEmployee(EmployeeDetails employeeDetails) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setJoiningDate(employeeDetails.getJoiningDate());
        employee.setRole(employeeDetails.getRole());
        employeeRepository.save(employee);
        return employeeDetails;
    }

    public List<EmployeeDetails> getEmployeesByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName)
                .stream()
                .map(emp -> new EmployeeDetails(emp.getFirstName(), emp.getLastName(), emp.getJoiningDate(), emp.getRole()))
                .collect(Collectors.toList());
    }

    public EmployeeDetails updateEmployee(String firstName, EmployeeDetails employeeDetails) {
        List<Employee> employees = employeeRepository.findByFirstName(firstName);
        if (!employees.isEmpty()) {
            Employee employee = employees.get(0);
            employee.setLastName(employeeDetails.getLastName());
            employee.setJoiningDate(employeeDetails.getJoiningDate());
            employee.setRole(employeeDetails.getRole());
            employeeRepository.save(employee);
            return employeeDetails;
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    public void deleteEmployee(String firstName) {
        Employee employee = employeeRepository.findByFirstName(firstName).get(0);
        employeeRepository.delete(employee);
    }
}
