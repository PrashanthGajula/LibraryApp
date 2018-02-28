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
import library.model.BookRequest;
import library.model.Category;
import library.service.BookService;
import library.service.CategoryService;

@Controller
@RequestMapping(value="/bookRequest")
public class BookRequestController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String bookRequestPage(Model model) {
		model.addAttribute("bookRequest", new BookRequest());
		return "bookRequest";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String bookRequest(Model model, @ModelAttribute ("bookRequest") BookRequest bookRequest) {
		System.out.println(bookRequest.getFullName() + " : "+ bookRequest.getCat_desc() + "  :  "+bookRequest.getBook_desc() +
				"  :  "+ bookRequest.getMessage());
		return "redirect:/home.html";
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
   
   @ModelAttribute("bookList")
   public Map<String, String> getBooksList(@ModelAttribute ("bookRequest") BookRequest bookRequest) {
	   List<Book> books = bookService.listBooks(bookRequest.getCat_desc());
	   Map<String, String> bookList = new HashMap<String, String>();
	   for(int i=0;i<books.size();i++) {
		   bookList.put(books.get(i).getBook_desc(), books.get(i).getBook_desc());
	   }
	   return bookList;
   }
	
}
