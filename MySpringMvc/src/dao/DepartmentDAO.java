package dao;/*
@author 黄大宁Rhinos
@date 2019/1/18 - 13:21
**/

import com.mysql.cj.protocol.Resultset;
import org.springframework.stereotype.Component;
import Util.DBUtil;
import entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class DepartmentDAO {
    public void add(Department bean) {
        String sql = "insert into department values(null,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
            ps.setString(1,bean.getDepartmentName());
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
        String sql = "delete from department where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
            ps.setInt(1,id);
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Department get(int id){
        Department bean = null;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();){
            String sql = "select * from department where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                bean = new Department();
                bean.setId(id);
                bean.setDepartmentName(rs.getString(2));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return bean;
    }

    public List<Department> getDepartments(){
        Department bean = null;
        List<Department> departments = new ArrayList<>();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();){
            String sql = "select * from department";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                bean = new Department();
                bean.setId(rs.getInt(1));
                bean.setDepartmentName(rs.getString(2));
                departments.add(bean);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return departments;
    }
}
