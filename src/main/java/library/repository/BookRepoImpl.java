package library.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import library.model.Book;

@Repository("bookRepo")
public class BookRepoImpl implements BookRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Book> listBooks(String category_desc) {
		String sql = "select * from book where cid = (select cid from category where category_desc='"+category_desc+"')";
		List<Book> books = jdbcTemplate.query(sql, new BookMapper());
		return books;
	}
	
	class BookMapper implements RowMapper<Book> {
		public Book mapRow(ResultSet rs, int arg1) throws SQLException {
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setCid(rs.getInt("cid"));
			book.setBook_desc(rs.getString("book_desc"));
			book.setQuantity(rs.getInt("quantity"));
			return book;
		}
	}
}
