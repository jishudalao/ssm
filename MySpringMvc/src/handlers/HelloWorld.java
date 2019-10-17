package handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sun.org.glassfish.gmbal.ManagedAttribute;

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import entity.Department;
import entity.Employee;
import entity.User;

@SessionAttributes(value={"user"},types= {String.class})
@Controller
public class HelloWorld {
	private final static String SUCCESS = "success";
	@RequestMapping("/helloworld")
	public String hello() {
		System.out.println("hello world");
		return "success";
	}
	
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod() {
		System.out.println("testMethod");
		return SUCCESS;
	}
	
	@RequestMapping(value="testParams",params= {"username","age!=10"})
	public String testParams() {
		System.out.println("testParams");
		return SUCCESS;
	}
	
	@RequestMapping(value="/pathVariable/{id}")
	private String testPathVariable(@PathVariable("id") Integer id) {
		// TODO Auto-generated method stub
		System.out.println("id="+id);
		return SUCCESS;
	}
	
	@RequestMapping(value="testTrans/{id}",method=RequestMethod.GET)
	public String testTrans(@PathVariable("id") Integer id) {
		System.out.println(" GET id="+id);
		return SUCCESS;
	}
	
	@RequestMapping(value="testTrans",method=RequestMethod.POST)
	public String testTrans() {
		System.out.println(" POST id=");
		return SUCCESS;
	}
	
	@RequestMapping(value="testTrans/{id}",method=RequestMethod.DELETE)
	public String testTransDelete(@PathVariable("id") Integer id) {
		System.out.println(" Delete id="+id);
		return SUCCESS;
	}
	
	@RequestMapping(value="testTrans/{id}",method=RequestMethod.PUT)
	public String testTransPut(@PathVariable("id") Integer id) {
		System.out.println(" PUT id="+id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam(value="username") String username,
			@RequestParam(value="age") Integer age) {
		System.out.println("username="+username+"   age="+age);
		return SUCCESS;
	}
	
	
	@RequestMapping("/testPOJO")
	public String testPojo(User user) {
		System.out.println("testPojo:"+user);
		return SUCCESS;
	}
	
	/*@RequestMapping("/testSession")
	public String testSession(Map<String,Object> map) {
		User user = new User("aaa","123456","123456@qq.com",19);
		map.put("user", user);
		map.put("mengyuan", "xuke");
		return SUCCESS;
	}
	*/
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,
			Map<String,Object>map) {
		if(id!=null) {
			User user = new User(1,"tom","123456","159357@qq.com",12);
			System.out.println("从数据库中获取一个对象:"+user);
			map.put("user", user);
		}
		
	}
	
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user) {
		System.out.println("修改:"+user);
		return SUCCESS;
	}
	
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private DepartmentDAO department;
	
	@RequestMapping("/list")
	public String list(Map<String, Object>map) {
		map.put("employees", employeeDAO.getAll());
		return "list";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String save (Employee employee) {
		employeeDAO.add(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="emp",method=RequestMethod.GET)
	public String input (Map<String, Object>map) {
		map.put("departments", department.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
