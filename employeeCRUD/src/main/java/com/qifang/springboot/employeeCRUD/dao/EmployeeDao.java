package com.qifang.springboot.employeeCRUD.dao;

import java.util.List;

import com.qifang.springboot.employeeCRUD.entity.Employee;

public interface EmployeeDao {
    public List<Employee> findAll();
    
    public Employee findById(int theId);
    
    public void save(Employee theEmployee);
    
    public void deleteById(int theId);
    
    
}
 