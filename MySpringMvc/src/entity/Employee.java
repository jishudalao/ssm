package entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;


@Component
public class Employee {
    private int id;

    @NotEmpty
    private String lastName;

    @Email
    private String email;
    private String gender;
    private int did;
    private Department department;

    //如果用util包下的Date会出�?,无法实现DataTimeFormat
    //如果用sql包下的，无法实现Validtor
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Employee() {
    }

    public Employee(int id, String lastName, String email, String gender, int did, Department department, Date birth) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.did = did;
        this.department = department;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", did=" + did +
                ", department=" + department +
                ", birth=" + birth +
                '}';
    }

    public Employee(int id, String lastName, String email, String gender, int did, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.did = did;
        this.department = department;
    }
}
