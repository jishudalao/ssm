package handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
	
	@RequestMapping("/helloworld")
	public String sayHello() {
		System.out.println("hello world");
		return "success";
	}
}
