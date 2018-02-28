package library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.model.Category;
import library.repository.CategoryRepo;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public List<Category> listCategories() {
		return categoryRepo.listCategories();
	}
}
