package entity;/*
@author 黄大宁Rhinos
@date 2019/1/18 - 13:17
**/

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Department {
    private int id;
    private String departmentName;
    private List<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }

	public Department(int id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
	}
    public Department() {}
}
