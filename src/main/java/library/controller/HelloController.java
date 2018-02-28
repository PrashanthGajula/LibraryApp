package library.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import library.model.User;
import library.service.UserService;

@Controller
public class HelloController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/greeting")
	public String sayHello(Model model) {
		model.addAttribute("greeting", "Hello World");
		return "hello";
	}
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("user", new User());
		return "welcome";
	}
	
   @ModelAttribute("usersList")
   public Map<String, String> getUsersList() {
	   List<User> users = userService.listUsers();
	   Map<String, String> usersList = new HashMap<String, String>();
	   for(int i=0;i<users.size();i++) {
		   usersList.put(users.get(i).getfName(), users.get(i).getfName());
	   }
	   return usersList;
   }
	
   @ModelAttribute("countryList")
   public Map<String, String> getCountryList() {
      Map<String, String> countryList = new HashMap<String, String>();
      countryList.put("US", "United States");
      countryList.put("CH", "China");
      countryList.put("SG", "Singapore");
      countryList.put("MY", "Malaysia");
      return countryList;
   }
}
