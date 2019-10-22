package handlers;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import entity.User;

@SessionAttributes(value={"user"},types = {String.class})
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
	
	@RequestMapping(value="testPOJO")
	public String testPOJO(User user) {
		System.out.println("testPOJO:"+user);
		return "success";
	}
	
	@RequestMapping(value="testModelAndView")
	public ModelAndView testModelAndView() {
		String viewName = "success";
		ModelAndView m = new ModelAndView(viewName);
		//添加模型数据到ModelAndView中
		m.addObject("time", new Date());
		return m;
	}
	
	@RequestMapping(value="testMap")
	public String testMap(Map<String,Object>map) {
		//添加模型数据到ModelAndView中
		map.put("names",Arrays.asList("aaa","bbb","ccc") );
		return "success";
	}
	
	@RequestMapping(value="testSessionAttribute")
	public String testSessionAttribute(Map<String,Object>map) {
		//添加模型数据到ModelAndView中
		User user = new User(1,"meng","123456","zhengzhou",20);
		map.put("user",user);
		return "success";
	}
	
	@RequestMapping(value="testSessionAttributeString")
	public String testSessionAttributeString(Map<String,Object>map) {
		//添加模型数据到ModelAndView中
		
		map.put("school","xiaoxue");
		return "success";
	}
	//ModelAttribute注解
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required = false)Integer id,Map<String,Object>map) {
		
		if(id!=null) {
		User user = new User(1,"meng","123456","zhengzhou",17);
			System.out.println("从数据库获取一个对象:"+user);
			map.put("user", user);
		}
	}
	@RequestMapping(value="testModelAttribute")
	public String testModelAttribute(@ModelAttribute("user")User user) {
		//添加模型数据到ModelAndView中
		System.out.println("修改:"+user);
		return "success";
	}
	
	@RequestMapping(value="testRedirect")
	public String testRedirect() {
		System.out.println("testRedirect");
		return "redirect:/index.jsp";
	}
	
	
}
