package library.service;

import java.util.List;
import library.model.Book;

public interface BookService {
	List<Book> listBooks(String category_desc);
}
