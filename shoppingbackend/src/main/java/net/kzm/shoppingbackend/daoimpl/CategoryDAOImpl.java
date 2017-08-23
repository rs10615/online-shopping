package net.kzm.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dto.Category;

import org.springframework.stereotype.Repository;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	public static List<Category> categories=new ArrayList<>();
	
	static{
		Category c=new Category();
		c.setId(1);
		c.setName("Televsion");
		c.setDescription("this description is for television");
        c.setImageURL("CAT_1.png");		
	
    	Category c1=new Category();
		c1.setId(2);
		c1.setName("Mobile");
		c1.setDescription("this description is for Mobile");
        c1.setImageURL("CAT_1.png");	
    	Category c2=new Category();
		c2.setId(3);
		c2.setName("Laptop");
		c2.setDescription("this description is for Laptop");
        c2.setImageURL("CAT_1.png");	
        categories.add(c);
        categories.add(c1);
        categories.add(c2);
	}
	
	
	@Override
	public List<Category> list() {
		
		return categories;
	}


	@Override
	public Category get(int id) {
		for(Category category:categories){
			if(category.getId()==id)
				return category;
			
		}
	return null;
	}

	
}
