package com.app.dao.impl;

import com.app.dao.IEmployeeDao;
import com.app.dbutil.DBConnection;
import com.app.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements IEmployeeDao {

    private static Connection connection;

    static {
        connection = DBConnection.getConnection();
    }

    @Override
    public Employee saveEmployee(Employee employee) throws SQLException {

        String sql = "insert into employee values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, employee.getEmpId());
        preparedStatement.setString(2, employee.getEmpName());
        preparedStatement.setString(3, employee.getCity());
        preparedStatement.setInt(4, employee.getAge());
        preparedStatement.setString(5, employee.getDepartment());

        int result = preparedStatement.executeUpdate();

        return employee;
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "delete from employee where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
    }

    @Override
    public Employee updateEmployee(Employee employee) throws SQLException {
        String sql = "update employee set name = ? , city = ? , age = ? , dept = ? where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, employee.getEmpName());
        preparedStatement.setString(2, employee.getCity());
        preparedStatement.setInt(3, employee.getAge());
        preparedStatement.setString(4, employee.getDepartment());
        preparedStatement.setInt(5, employee.getEmpId());

        preparedStatement.executeUpdate();
        return employee;
    }

    @Override
    public Employee getOneEmployee(int id) throws SQLException {
        String sql = "select * from employee where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Employee employee = null;
        if (resultSet.next()) {
            employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        String sql = "select * from employee";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Employee> employeeList = new ArrayList<>();
        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    protected void finalize() throws Throwable {
        connection.close();
        super.finalize();
    }
}
