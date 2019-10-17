package handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/SpringMvc")
public class Test {
	@RequestMapping("/test")
	public String testMapping() {
		System.out.println("just test");
		return "success";
	}
	@RequestMapping(value="/postMethod",method=RequestMethod.POST)
	public String testMethod() {
		System.out.println("test method");
		return "success";
	}
	@RequestMapping(value="testParam",params= {"username","age!=10"})
	public String testParam() {
		System.out.println("test param");
		return "success";
	}
	@RequestMapping(value="testPathVariable/*/{id}")
	public String testPthVariable(@PathVariable(value="id")Integer id) {
		System.out.println("id="+id);
		return "success";
	}
	
	//testRest
	@RequestMapping(value="testRest/{id}",method=RequestMethod.GET)
	public String testRest(@PathVariable(value="id")Integer id) {
		System.out.println("id="+id);
		return "success";
	}
	
	@RequestMapping(value="testRest",method=RequestMethod.POST)
	public String testRest() {
		System.out.println("testRest");
		return "success";
	}
	
	@RequestMapping(value="testRest/{id}",method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable(value="id")Integer id) {
		System.out.println("id="+id);
		return "success";
	}
	
	@RequestMapping(value="testRest/{id}",method=RequestMethod.PUT)
	public String testRestPut(@PathVariable(value="id")Integer id) {
		System.out.println("id="+id);
		return "success";
	}
	
	@RequestMapping(value="testRequestParam")
	public String testRequestParam(@RequestParam(value="username")String username,
			@RequestParam(value="age",required = false,defaultValue = "0")int age) {
		System.out.println("username:"+username);
		System.out.println("age:"+age);
		return "success";
	}
	
	
}
