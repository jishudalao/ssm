package dao;/*
@author 黄大宁Rhinos
@date 2019/1/18 - 13:45
**/

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import entity.Department;
import entity.Employee;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
//        Employee employee = new Employee();
//        employee.setLastName("cai");
//        employee.setEmail("999@aaa.com");
//        employee.setGender("female");
//        employee.setDid(4);
//        employeeDAO.add(employee);
        List<Employee> employees= employeeDAO.getAll();
        for(Employee e : employees){
            System.out.println(e);
        }


    }
}
