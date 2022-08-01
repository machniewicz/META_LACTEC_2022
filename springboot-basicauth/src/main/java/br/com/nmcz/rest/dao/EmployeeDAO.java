package br.com.nmcz.rest.dao;

import org.springframework.stereotype.Repository;

import br.com.nmcz.rest.model.Employee;
import br.com.nmcz.rest.model.Employees;

@Repository
public class EmployeeDAO 
{
    private static Employees list = new Employees();
    
    static 
    {
        list.getEmployeeList().add(new Employee(1, "João", "Silva", "js@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Alex", "Santos", "santos@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "Maria", "Carmen", "carmen@gmail.com"));
    }
    
    public Employees getAllEmployees() 
    {
        return list;
    }
    
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
