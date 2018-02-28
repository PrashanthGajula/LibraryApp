package library.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import library.model.Category;

@Repository("categoryRepo")
public class CategoryRepoImpl implements CategoryRepo{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Category> listCategories() {
		String sql = "select * from category";
		List<Category> categories = jdbcTemplate.query(sql, new CategoryMapper());
		return categories;
	}
	
	class CategoryMapper implements RowMapper<Category> {
		public Category mapRow(ResultSet rs, int arg1) throws SQLException {
		    Category category = new Category();
		    category.setCid(rs.getInt("cid"));
		    category.setCategory_desc(rs.getString("category_desc"));
		    return category;
		}
	}
}
