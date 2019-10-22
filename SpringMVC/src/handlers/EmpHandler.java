package handlers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.DepartmentDao;
import dao.EmployeeDao;
import entity.Employee;

@Controller
public class EmpHandler {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}



	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required = false) Integer id,Map<String,Object> map) {
		if(id!=null) {
			map.put("employee", employeeDao.get(id));
		}
	}

	@RequestMapping(value="/emps")
	public String list(Map<String,Object>map) {
		map.put("employees", employeeDao.getAll());
		return "list";
	}
	
	@Autowired
	private DepartmentDao departmentDao;
	@RequestMapping(value="/emp",method = RequestMethod.GET)
	public String add(Map<String,Object>map) {
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
	
	
	@RequestMapping(value="/emp",method = RequestMethod.POST)
	public String save(@Valid Employee employee,BindingResult result,Map<String,Object>map) {
		if(result.getErrorCount()>0) {
			System.out.println("出错了");
			for(FieldError error:result.getFieldErrors()) {
				System.out.println(error.getField()+":"+error.getDefaultMessage());
			}
			//做表单回显
			map.put("departments", departmentDao.getDepartments());
			return "input";
		}
		employeeDao.save(employee);
		System.out.println(employee);
		return "redirect:/emps";
	}
	
	
	
	@RequestMapping(value="/emp/{id}",method = RequestMethod.DELETE)
	public String delete(@PathVariable(value="id")Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp/{id}",method = RequestMethod.GET)
	public String input(@PathVariable(value="id")Integer id,Map<String,Object> map) {
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}
	
	@RequestMapping(value="/emp",method = RequestMethod.PUT)
	public String update(Employee employee) {
		employeeDao.save(employee);
		
		return "redirect:/emps";
	}
	
	@RequestMapping("testConversionServiceConverter")
	public String testConverter(@RequestParam("employee") Employee employee) {
		employeeDao.save(employee);
		System.out.println(employee);
		return "redirect:/emps";
	}
	/*
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("lastName");
	}
	*/
	@ResponseBody
	@RequestMapping("testJson")
	public Collection<Employee> testJson(){
		return employeeDao.getAll();
	}
	
	@ResponseBody
	@RequestMapping("testHttpMessageConverter")
	public String testHttpMessageConverter(@RequestBody String body) {
		System.out.println(body);
		return "helloworld!"+ new Date();
	}
	@RequestMapping("testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession httpSession) throws IOException{
		byte[] body = null;
		ServletContext servletContext = httpSession.getServletContext();
		InputStream in = servletContext.getResourceAsStream("files/jquery-1.12.0.min.js");
		body = new byte[in.available()];
		in.read(body);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Dispatcher", "attachment;filename=jquery-1.12.0.min.js");
		HttpStatus statusCode = HttpStatus.OK;
		
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body,headers,statusCode);
		
		return responseEntity;
	}
	
	@RequestMapping("testFileUpload")
	public String testFileUpload(@RequestParam("desc") String desc,@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("desc"+desc);
		System.out.println("name"+file.getOriginalFilename());
		System.out.println("inputStream"+file.getInputStream());
		return "success";
	}
}
