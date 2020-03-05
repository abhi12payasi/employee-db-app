package com.app.model;

public class Employee {
    private int empId;
    private String empName;
    private String city;
    private int age;
    private String department;

    public Employee() {
    }

    public Employee(int empId, String empName, String city, int age, String department) {
        this.empId = empId;
        this.empName = empName;
        this.city = city;
        this.age = age;
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}
