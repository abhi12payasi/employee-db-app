package com.app.service.impl;

import com.app.dao.IEmployeeDao;
import com.app.dao.impl.EmployeeDaoImpl;
import com.app.model.Employee;
import com.app.service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private static IEmployeeDao employeeDAO;
    static {
        employeeDAO = new EmployeeDaoImpl();
    }
    @Override
    public int saveEmployee(Employee employee) throws SQLException {
        return employeeDAO.saveEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException{
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public Employee getOneEmployee(int id) throws SQLException{
        return employeeDAO.getOneEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException{
        return employeeDAO.getAllEmployees();
    }
}
