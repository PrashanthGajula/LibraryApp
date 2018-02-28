package library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.model.Book;
import library.repository.BookRepo;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public List<Book> listBooks(String category_desc) {
		return bookRepo.listBooks(category_desc);
	}
}
