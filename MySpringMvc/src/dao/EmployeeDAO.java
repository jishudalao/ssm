package dao;/*
@author 榛勫ぇ瀹丷hinos
@date 2019/1/18 - 13:20
**/

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import Util.DBUtil;
import entity.Department;
import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {
    public void add(Employee bean) {
        String sql = "insert into employee values(null,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            ps.setString(1,bean.getLastName());
            ps.setString(2,bean.getEmail());
            ps.setString(3,bean.getGender());
            ps.setInt(4,bean.getDid());
            System.out.println("鑾峰彇鍒扮殑id涓� " + bean.getDid());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                bean.setId(id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "delete from employee where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
            ps.setInt(1,id);
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Employee get(int id){
        Employee bean = null;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();){
            String sql = "select * from employee where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                bean = new Employee();
                bean.setId(id);
                bean.setLastName(rs.getString(2));
                bean.setEmail(rs.getString(3));
                bean.setGender(rs.getString(4));
                DepartmentDAO departmentDAO = new DepartmentDAO();
                bean.setDepartment(departmentDAO.get(rs.getInt(5)));
                bean.setDid(rs.getInt(5));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return bean;
    }

    public List<Employee> getAll(){
        Employee bean = null;
        List<Employee> employees =new  ArrayList<Employee>();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();){
            String sql = "select * from employee";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                bean = new Employee();
                bean.setId(rs.getInt(1));
                bean.setLastName(rs.getString(2));
                bean.setEmail(rs.getString(3));
                bean.setGender(rs.getString(4));
                bean.setDid(rs.getInt(5));
                DepartmentDAO departmentDAO = new DepartmentDAO();
                bean.setDepartment(departmentDAO.get(rs.getInt(5)));
                employees.add(bean);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return employees;
    }

    public void update(Employee bean){
        String sql = "update employee set lastName=?, email=?, gender=?, did=? where id= ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            ps.setString(1,bean.getLastName());
            ps.setString(2,bean.getEmail());
            ps.setString(3,bean.getGender());
            ps.setInt(4,bean.getDid());
            ps.setInt(5,bean.getId());
            ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
