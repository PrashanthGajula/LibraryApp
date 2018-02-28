package library.repository;

import java.util.List;

import library.model.Book;

public interface BookRepo {
	List<Book> listBooks(String category_desc);
}
