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

import library.model.Book;
import library.model.Category;
import library.service.BookService;
import library.service.CategoryService;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BookService bookService;

	@RequestMapping(method = RequestMethod.GET)
	public String HomePageLoad(Model model) {
		model.addAttribute("category", new Category());
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String HomePage(Model model, @ModelAttribute ("category") Category category) {
		System.out.println(category.getCategory_desc());
		List<Book> books = bookService.listBooks(category.getCategory_desc());
		model.addAttribute("bookList", books);
		return "home";
	}
	
   @ModelAttribute("categoryList")
   public Map<String, String> getCategoriesList() {
	   List<Category> categories = categoryService.listCategories();
	   Map<String, String> categoryList = new HashMap<String, String>();
	   for(int i=0;i<categories.size();i++) {
		   categoryList.put(categories.get(i).getCategory_desc(), categories.get(i).getCategory_desc());
	   }
	   return categoryList;
   }
}
