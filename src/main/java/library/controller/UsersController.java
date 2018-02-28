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
@RequestMapping(value = "/addUser")
public class UsersController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String loadUserRegistrationPage(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addUser(@ModelAttribute ("user") User user) {
		User newUser = userService.createUser(user);
		System.out.println(newUser.getUid());
		if(!(newUser.getUid() <= 0)) {
			return "redirect:/home.html";
		}
		return "addUser";
	}
}
