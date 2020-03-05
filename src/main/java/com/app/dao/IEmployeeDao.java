package com.app.dao;

import com.app.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDao {

    int saveEmployee(Employee employee) throws SQLException;
    void deleteEmployee(int id) throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    Employee getOneEmployee(int id) throws SQLException;
    List<Employee> getAllEmployees() throws SQLException;
}
