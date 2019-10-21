package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;
import service.UserService;

public class UserAction  extends ActionSupport implements ModelDriven<User> {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public String login() {
		User existUser = userService.login(user);
		if (existUser == null) {
			// µÇÂ¼Ê§°Ü
			
			return "error";
		}
		if(existUser.getUsername().equals("aaa")&&existUser.getPassword().equals("aaa")) {
			return "loginSuccess";
		}
		else {
			return "error";
		}
		
	}
	
}
