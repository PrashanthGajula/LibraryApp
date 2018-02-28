package library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import library.model.User;
import library.service.UserService;

@Controller
@SessionAttributes(value = "user")
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private UserService userService;	
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute ("login") User user) {
		System.out.println(user.getUserName()+  "  " + user.getPassword());
		User newUser = userService.userLogin(user);
		if(newUser != null) {
			return "redirect:/home.html";
		} else {
			model.addAttribute("error", "Invalid Details, Please Enter valid details");
			return "login";
		}
	}
}
