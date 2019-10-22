package entity;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;


public class Employee {
    private Integer id;
    @NotEmpty
    private String lastName;
    @Email
    private String email;
    private int gender;
    private Department department;
    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;
    
    @NumberFormat(pattern="#,###,###.#")
    private Float salary;
    
    public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	
  

    public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

   

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    
    public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Employee() {
    }

	public Employee(Integer id, String lastName, String email, int gender, Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender
				+ ", department=" + department + ", salary=" + salary + ", birth=" + birth + "]";
	}

	

	
	

   


    
}
